import com.jfinal.aop.Invocation;
import com.jfinal.core.*;
import com.jfinal.log.Log;
import com.jfinal.render.Render;
import com.jfinal.render.RenderException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/8/19
 */
public class MyActionHandler extends ActionHandler {

    private static final Log log = Log.getLog(ActionHandler.class);

    /**
     * handle
     * 1: Action action = actionMapping.getAction(target)
     * 2: new Invocation(...).invoke()
     * 3: render(...)
     */
    public void handle(String target, HttpServletRequest request, HttpServletResponse response, boolean[] isHandled) {
        if (target.indexOf('.') != -1) {
            return;
        }

        isHandled[0] = true;
        String[] urlPara = {null};
        Action action = actionMapping.getAction(target, urlPara);

        if (action == null) {
            if (log.isWarnEnabled()) {
                String qs = request.getQueryString();
                log.warn("404 Action Not Found: " + (qs == null ? target : target + "?" + qs));
            }
            renderManager.getRenderFactory().getErrorRender(404).setContext(request, response).render();
            return;
        }

        Controller controller = null;

        try {
            controller = controllerFactory.getController(action.getControllerClass());

            boolean injectDependency = false;
            if (injectDependency) {
                com.jfinal.aop.Aop.inject(controller);
            }
            CPI._init_(controller, action, request, response, urlPara[0]);

            new Invocation(action, controller).invoke();

            Render render = controller.getRender();
            if (render instanceof ForwardActionRender) {
                String actionUrl = ((ForwardActionRender) render).getActionUrl();
                if (target.equals(actionUrl)) {
                    throw new RuntimeException("The forward action url is the same as before.");
                } else {
                    handle(actionUrl, request, response, isHandled);
                }
                return;
            }

            if (render == null) {
                render = renderManager.getRenderFactory().getDefaultRender(action.getViewPath() + action.getMethodName());
            }
            render.setContext(request, response, action.getViewPath()).render();
        } catch (RenderException e) {
            if (log.isErrorEnabled()) {
                String qs = request.getQueryString();
                log.error(qs == null ? target : target + "?" + qs, e);
            }
        } catch (ActionException e) {
            handleActionException(target, request, response, action, e);
        } catch (Exception e) {
            if (log.isErrorEnabled()) {
                String qs = request.getQueryString();
                log.error(qs == null ? target : target + "?" + qs, e);
            }
            renderManager.getRenderFactory().getErrorRender(500).setContext(request, response, action.getViewPath()).render();
        } finally {
            if (controller != null) {
                CPI._clear_(controller);
            }
        }
    }

    /**
     * 抽取出该方法是为了缩短 handle 方法中的代码量，确保获得 JIT 优化，
     * 方法长度超过 8000 个字节码时，将不会被 JIT 编译成二进制码
     * <p>
     * 通过开启 java 的 -XX:+PrintCompilation 启动参数得知，handle(...)
     * 方法(73 行代码)已被 JIT 优化，优化后的字节码长度为 593 个字节，相当于
     * 每行代码产生 8.123 个字节
     */
    private void handleActionException(String target, HttpServletRequest request, HttpServletResponse response, Action action, ActionException e) {
        int errorCode = e.getErrorCode();
        String msg = null;
        if (errorCode == 404) {
            msg = "404 Not Found: ";
        } else if (errorCode == 400) {
            msg = "400 Bad Request: ";
        } else if (errorCode == 401) {
            msg = "401 Unauthorized: ";
        } else if (errorCode == 403) {
            msg = "403 Forbidden: ";
        }

        if (msg != null) {
            if (log.isWarnEnabled()) {
                String qs = request.getQueryString();
                msg = msg + (qs == null ? target : target + "?" + qs);
                if (e.getMessage() != null) {
                    msg = msg + "\n" + e.getMessage();
                }
                log.warn(msg);
            }
        } else {
            if (log.isErrorEnabled()) {
                String qs = request.getQueryString();
                log.error(errorCode + " Error: " + (qs == null ? target : target + "?" + qs), e);
            }
        }

        e.getErrorRender().setContext(request, response, action.getViewPath()).render();
    }
}
