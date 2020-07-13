package charpter3.netty;

import org.jboss.marshalling.Marshaller;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/5/25
 */
public class MarshallingEncoder {

    private static final byte[] LENGTH = new byte[4];

    Marshaller marshaller;

    public MarshallingEncoder() {


    }
}
