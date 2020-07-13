package handlerchain;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/7/13
 */
public class Info {

    private String infoId;

    private String info;

    public Info(String infoId, String info) {
        this.infoId = infoId;
        this.info = info;
    }

    public String getInfoId() {
        return infoId;
    }

    public void setInfoId(String infoId) {
        this.infoId = infoId;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Info{" +
                "infoId='" + infoId + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
