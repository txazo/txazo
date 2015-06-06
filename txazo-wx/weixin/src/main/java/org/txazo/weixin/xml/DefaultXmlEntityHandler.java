package org.txazo.weixin.xml;

import org.txazo.weixin.enums.EntityPath;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import java.lang.reflect.Field;
import java.util.*;

/**
 * DefaultXmlEntityHandler
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 06.06.2015
 */
public class DefaultXmlEntityHandler<T extends XmlEntity> extends XmlEntityHandler {

    private static final String SEP_NODE = ".";
    private static final String SEP_ATTR = "#";

    /** 当前节点 */
    private String currNode;
    /** 当前节点路径 */
    private String path;
    /** 上级节点路径 */
    private String prevPath;
    /** 实体类路径 */
    private String classPath;
    /** 实体属性路径 */
    private Map<String, String> fieldPaths;
    /** 实体类class */
    private Class<T> clazz;
    /** 当前实体 */
    private T current;
    /** 实体结果集 */
    protected List<T> entitys = new ArrayList<T>();

    public DefaultXmlEntityHandler(Class<T> clazz) {
        super();
        this.clazz = clazz;

        initEntityPath();
    }

    private void initEntityPath() {
        EntityPath entityPath = clazz.getAnnotation(EntityPath.class);
        classPath = (entityPath != null) ? entityPath.path() : clazz.getSimpleName().toLowerCase();

        fieldPaths = new HashMap<String, String>();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            entityPath = field.getAnnotation(EntityPath.class);
            fieldPaths.put((entityPath != null) ? entityPath.path() : classPath + SEP_NODE + field.getName(), field.getName());
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        plusPath(qName);

        try {
            /** 实体父节点 */
            if (path.equals(classPath)) {
                current = clazz.newInstance();
            }

            /** 实体属性 */
            Field field = null;
            String fieldName = null;
            String attributeValue = null;
            Map.Entry entry = null;
            for (Iterator<Map.Entry<String, String>> iterator = fieldPaths.entrySet().iterator(); iterator.hasNext(); ) {
                entry = iterator.next();
                fieldName = entry.getValue().toString();
                if ((path + SEP_ATTR + fieldName).equals(entry.getKey()) && attributes.getIndex(fieldName) >= 0) {
                    attributeValue = attributes.getValue(fieldName);
                    field = clazz.getDeclaredField(fieldName);
                    field.setAccessible(true);
                    field.set(current, attributeValue);
                }
            }

            /** 实体子节点 */
            if (fieldPaths.containsKey(prevPath + SEP_NODE + qName)) {
                currNode = qName;
            }
        } catch (Exception e) {
            throw new SAXException(e);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currNode != null) {
            try {
                Field field = clazz.getDeclaredField(currNode);
                field.setAccessible(true);
                field.set(current, new String(ch, start, length));
            } catch (Exception e) {
                throw new SAXException(e);
            } finally {
                currNode = null;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (path.equals(classPath)) {
            entitys.add(current);
        }

        minusPath();
    }

    private void plusPath(String qName) {
        prevPath = path;
        path = (path == null) ? qName : path + SEP_NODE + qName;
    }

    private void minusPath() {
        if (path != null) {
            int index = path.lastIndexOf(SEP_NODE);
            path = (index == -1) ? null : path.substring(0, index);
        }

        if (prevPath != null) {
            int index = prevPath.lastIndexOf(SEP_NODE);
            prevPath = (index == -1) ? null : prevPath.substring(0, index);
        }
    }

    @Override
    public List<T> getResultEntity() {
        return entitys;
    }

}
