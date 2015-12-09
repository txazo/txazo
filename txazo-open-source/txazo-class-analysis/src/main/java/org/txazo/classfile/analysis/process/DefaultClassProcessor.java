package org.txazo.classfile.analysis.process;

import org.txazo.classfile.analysis.config.Tag;
import org.txazo.classfile.analysis.core.ClassReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultClassProcessor implements ClassProcessor {

    private Map<String, Object> valueStack = new HashMap<String, Object>();

    @Override
    public Map<String, Object> process(Tag tag, ClassReader reader) {
        if (tag.isRoot()) {
            List<Map<String, Object>> childs = new ArrayList<Map<String, Object>>();
            for (Tag child : tag.getChilds()) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put(tag.getName(), process(tag, reader));
            }
            Map<String, Object> map = new HashMap<String, Object>();
            map.put(tag.getName(), childs);
            return map;
        } else if (tag.getName().equals("array")) {
            int length = tag.getAttribute("length", int.class);
            List<Map<String, Object>> childs = new ArrayList<Map<String, Object>>();
            for (int i = 0; i < length; i++) {

            }
        } else if (tag.getName().equals("item")) {

        } else if (tag.getName().equals("select")) {
            return processSelect(tag, reader, 1);
        } else if (tag.getName().equals("option")) {

        }
        return null;
    }

    private Map<String, Object> processSelect(Tag tag, ClassReader reader, int value) {
        for (Tag option : tag.getChilds()) {
            if (value == option.getAttribute("value", int.class)) {
                Map<String, Object> map = new HashMap<String, Object>();
                for (Tag optionChild : option.getChilds()) {
                    map.put(optionChild.getName(), process(optionChild, reader));
                }
                return map;
            }
        }
        return null;
    }

}
