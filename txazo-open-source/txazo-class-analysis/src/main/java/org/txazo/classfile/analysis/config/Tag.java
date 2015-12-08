package org.txazo.classfile.analysis.config;

import java.util.*;

public class Tag {

    public static final String ROOT_TAG_NAME = "class";
    private static final Set<String> PARENT_TAG_NAME_SET = new HashSet<String>(Arrays.asList(new String[]{"array", "select", "option"}));

    private String name;

    private Map<String, String> attributes = new HashMap<String, String>();

    private List<Tag> childs = new ArrayList<Tag>();

    public Tag(String name) {
        this.name = name;
    }

    public Tag(String name, Map<String, String> attributes) {
        this.name = name;
        this.attributes = attributes;
    }

    public void addChild(Tag child) {
        childs.add(child);
    }

    public boolean isRoot() {
        return ROOT_TAG_NAME.endsWith(name);
    }

    public boolean isParent() {
        return PARENT_TAG_NAME_SET.contains(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
