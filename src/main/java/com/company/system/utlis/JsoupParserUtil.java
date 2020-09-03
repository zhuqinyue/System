//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company.system.utlis;

import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupParserUtil {
    public JsoupParserUtil() {
    }

    public static Element getElementById(Document document, String id) {
        Element element = null;
        if(document != null && id != null && !"".equals(id.trim())) {
            element = document.getElementById(id);
        }

        return element;
    }

    public static Element getElementById(Element element, String id) {
        Element resultElement = null;
        if(element != null) {
            resultElement = element.getElementById(id);
        }

        return resultElement;
    }

    public static Elements getElementsByTagName(Document document, String tagName) {
        Elements elements = null;
        if(document != null && tagName != null && !"".equals(tagName)) {
            elements = document.getElementsByTag(tagName);
        }

        return elements;
    }

    public static Elements getElementsByTagName(Element element, String tagName) {
        Elements resultElements = null;
        if(element != null && tagName != null && !"".equals(tagName)) {
            resultElements = element.getElementsByTag(tagName);
        }

        return resultElements;
    }

    public static Elements getElementsByClassName(Document document, String className) {
        Elements elements = null;
        if(document != null && className != null && !"".equals(className.trim())) {
            elements = document.getElementsByClass(className);
        }

        return elements;
    }

    public static Elements getElementsByClassName(Element element, String className) {
        Elements resultElements = null;
        if(element != null && className != null && !"".equals(className)) {
            resultElements = element.getElementsByClass(className);
        }

        return resultElements;
    }

    public static Elements getElementsByAttributeNameKey(Document document, String attributeNameKey) {
        Elements elements = null;
        if(document != null && attributeNameKey != null && !"".equals(attributeNameKey)) {
            elements = document.getElementsByAttribute(attributeNameKey);
        }

        return elements;
    }

    public static Elements getElementsByAttributeNameKey(Element element, String attributeNameKey) {
        Elements resultElements = null;
        if(element != null && attributeNameKey != null && !"".equals(attributeNameKey)) {
            resultElements = element.getElementsByAttribute(attributeNameKey);
        }

        return resultElements;
    }

    public static Elements getElementsByAttributeNameValue(Document document, String attributeKey, String attributeValue) {
        Elements elements = null;
        if(document != null && attributeKey != null && !"".equals(attributeKey.trim()) && attributeValue != null && !"".equals(attributeValue.trim())) {
            elements = document.getElementsByAttributeValue(attributeKey, attributeValue);
        }

        return elements;
    }

    public static Elements getElementsByAttributeNameValue(Element element, String attributeKey, String attributeValue) {
        Elements resultElements = null;
        if(element != null && attributeKey != null && !"".equals(attributeKey.trim()) && attributeValue != null && !"".equals(attributeValue.trim())) {
            resultElements = element.getElementsByAttributeValue(attributeKey, attributeValue);
        }

        return resultElements;
    }

    public static Elements getElementsByAttributeNameStartWithValue(Document document, String keyValue) {
        Elements elements = null;
        if(document != null && keyValue != null && !"".equals(keyValue.trim())) {
            elements = document.getElementsByAttributeStarting(keyValue);
        }

        return elements;
    }

    public static Elements getElementsByAttributeNameStartWithValue(Element element, String keyValue) {
        Elements elements = null;
        if(element != null && keyValue != null && !"".equals(keyValue.trim())) {
            elements = element.getElementsByAttributeStarting(keyValue);
        }

        return elements;
    }

    public static Elements getElementsByAttributeValueContaining(Document document, String attributeKey, String containValue) {
        Elements elements = null;
        if(document != null && containValue != null && !"".equals(containValue)) {
            elements = document.getElementsByAttributeValueContaining(attributeKey, containValue);
        }

        return elements;
    }

    public static Elements getElementsByAttributeValueContaining(Element element, String attributeKey, String containValue) {
        Elements elements = null;
        if(element != null && containValue != null && !"".equals(containValue)) {
            elements = element.getElementsByAttributeValueContaining(attributeKey, containValue);
        }

        return elements;
    }

    public static Elements getElementsByAttributeValueEnding(Document document, String attributeKey, String valueSuffix) {
        Elements elements = null;
        if(document != null && attributeKey != null && !"".equals(attributeKey) && valueSuffix != null && !"".equals(valueSuffix)) {
            elements = document.getElementsByAttributeValueEnding(attributeKey, valueSuffix);
        }

        return elements;
    }

    public static Elements getElementsByAttributeValueEnding(Element element, String attributeKey, String valueSuffix) {
        Elements elements = null;
        if(element != null && attributeKey != null && !"".equals(attributeKey) && valueSuffix != null && !"".equals(valueSuffix)) {
            elements = element.getElementsByAttributeValueEnding(attributeKey, valueSuffix);
        }

        return elements;
    }

    public static Elements getElementsByAttributeValueMatching(Document document, String attributeKey, Pattern pattern) {
        Elements elements = null;
        if(document != null && attributeKey != null && !"".equals(attributeKey) && pattern != null) {
            elements = document.getElementsByAttributeValueMatching(attributeKey, pattern);
        }

        return elements;
    }

    public static Elements getElementsByAttributeValueMatching(Element element, String attributeKey, Pattern pattern) {
        Elements elements = null;
        if(element != null && attributeKey != null && !"".equals(attributeKey) && pattern != null) {
            elements = element.getElementsByAttributeValueMatching(attributeKey, pattern);
        }

        return elements;
    }

    public static Elements getElementsByAttributeValueMatching(Document document, String attributeKey, String regualRegx) {
        Elements elements = null;
        if(document != null && attributeKey != null && !"".equals(attributeKey) && regualRegx != null && !"".equals(regualRegx)) {
            elements = document.getElementsByAttributeValueMatching(attributeKey, regualRegx);
        }

        return elements;
    }

    public static Elements getElementsByAttributeValueMatching(Element element, String attributeKey, String regualRegx) {
        Elements elements = null;
        if(element != null && attributeKey != null && !"".equals(attributeKey) && regualRegx != null && !"".equals(regualRegx)) {
            elements = element.getElementsByAttributeValueMatching(attributeKey, regualRegx);
        }

        return elements;
    }

    public static Elements getElementsByAttributeValueNot(Document document, String attributeKey, String attributeValue) {
        Elements elements = null;
        if(document != null && attributeKey != null && !"".equals(attributeKey) && attributeValue != null && !"".equals(attributeValue)) {
            elements = document.getElementsByAttributeValueNot(attributeKey, attributeValue);
        }

        return elements;
    }

    public static Elements getElementsByAttributeValueNot(Element element, String attributeKey, String attributeValue) {
        Elements elements = null;
        if(element != null && attributeKey != null && !"".equals(attributeKey) && attributeValue != null && !"".equals(attributeValue)) {
            elements = element.getElementsByAttributeValueNot(attributeKey, attributeValue);
        }

        return elements;
    }

    public static Elements getMoreElementsBySelectStr(Document document, String selectStr) {
        if(document != null && selectStr != null && !"".equals(selectStr.trim())) {
            Elements elements = document.select(selectStr);
            return elements != null && elements.size() > 0?elements:null;
        } else {
            return null;
        }
    }

    public static Elements getMoreElementsBySelectStr(Element element, String selectStr) {
        if(element != null && selectStr != null && !"".equals(selectStr.trim())) {
            Elements elements = element.select(selectStr);
            return elements != null && elements.size() > 0?elements:null;
        } else {
            return null;
        }
    }

    public static Element getSingleElementBySelectStr(Document document, String selectStr) {
        Elements elements = getMoreElementsBySelectStr(document, selectStr);
        return elements != null && elements.size() > 0?(Element)elements.get(0):null;
    }

    public static Element getSingleElementBySelectStr(Element element, String selectStr) {
        Elements elements = getMoreElementsBySelectStr(element, selectStr);
        return elements != null && elements.size() > 0?(Element)elements.get(0):null;
    }

    public static String getSingleElementHtmlBySelectStr(Document document, String selectStr) {
        Element element = getSingleElementBySelectStr(document, selectStr);
        return element != null?element.html():null;
    }

    public static String getSingleElementHtmlBySelectStr(Element element, String selectStr) {
        Element ele = getSingleElementBySelectStr(element, selectStr);
        return ele != null?ele.html():null;
    }

    public static String getAttributeValue(Element element, String attributeName) {
        String attributeValue = null;
        if(element != null && attributeName != null && !"".equals(attributeName)) {
            attributeValue = element.attr(attributeName);
        }

        return attributeValue;
    }

    public static String getSingElementHtml(Elements elements) {
        Element ele = null;
        String htmlStr = null;
        if(elements != null && elements.size() > 0) {
            ele = (Element)elements.get(0);
            htmlStr = ele.html();
        }

        return htmlStr;
    }

    public static String getSingElementText(Elements elements) {
        Element ele = null;
        String htmlStr = null;
        if(elements != null && elements.size() > 0) {
            ele = (Element)elements.get(0);
            htmlStr = ele.text();
        }

        return htmlStr;
    }

    public static void main(String[] args) {
        File file = new File("F:/example.htm");

        try {
            Document e = Jsoup.parse(file, "GB2312");
        } catch (IOException var3) {
            var3.printStackTrace();
        }

    }
}
