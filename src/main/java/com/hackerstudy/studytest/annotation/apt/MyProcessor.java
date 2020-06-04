package com.hackerstudy.studytest.annotation.apt;

import com.google.auto.service.AutoService;
import com.hackerstudy.studytest.annotation.LengthDetection;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @class: MyProcessor
 * @description: 基于apt的注解处理类
 * @author: HackerStudy
 * @date: 2020-06-04 17:54
 */
@AutoService(LengthDetection.class)
public class MyProcessor extends AbstractProcessor {
    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        System.out.println("-----process():-------");

        // 通过我们指定的注解返回与这个注解绑定的element集合
        Set<? extends Element> annotationElements = roundEnvironment.getElementsAnnotatedWith(LengthDetection.class);
        // 遍历当前element集合
        for (Element element : annotationElements){
            // 通过element的种类将他转成element的实现类
            if (element.getKind() == ElementKind.CLASS){
                TypeElement typeElement = (TypeElement) element;
                // 通过element的具体的实现类获取注解的值
                System.out.println(typeElement.getAnnotation(LengthDetection.class).max());
                System.out.println(typeElement.getAnnotation(LengthDetection.class).min());
                System.out.println(typeElement.getAnnotation(LengthDetection.class).description());
            }
        }

        return true;
    }

    // 规定这个注解处理器处理的注解
    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> set = new LinkedHashSet<>();
        set.add(LengthDetection.class.getCanonicalName());
        return set;
    }

    //指定java版本
    @Override
    public SourceVersion getSupportedSourceVersion() {
        return super.getSupportedSourceVersion();
    }
}
