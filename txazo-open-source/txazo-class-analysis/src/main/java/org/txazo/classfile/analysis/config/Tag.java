package org.txazo.classfile.analysis.config;

import java.util.*;

public class Tag {

    public static final String ROOT_TAG = "class";
    private static final Set<String> PARENT_TAG_SET = new HashSet<String>(Arrays.asList(new String[]{"array", "select", "option"}));

    private String tag;

    private Map<String, String> attributes = new HashMap<String, String>();

    private List<Tag> childs = new ArrayList<Tag>();

    public Tag(String tag) {
        this.tag = tag;
    }

    public Tag(String tag, Map<String, String> attributes) {
        this.tag = tag;
        this.attributes = attributes;
    }

    public void addChild(Tag child) {
        childs.add(child);
    }

    public boolean isRoot() {
        return ROOT_TAG.equals(tag);
    }

    public boolean isParent() {
        return PARENT_TAG_SET.contains(tag);
    }

    public String getId() {
        return getAttribute("id", String.class);
    }

    public String getName() {
        return getAttribute("name", String.class);
    }

    public <T> T getAttribute(String key, Class<T> clazz) {
        return (T) attributes.get(key);
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public List<Tag> getChilds() {
        return childs;
    }

    public void setChilds(List<Tag> childs) {
        this.childs = childs;
    }

}
