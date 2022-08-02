package com.example.study.testDemo.spelDemo;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.testng.annotations.Test;

import javax.el.StandardELContext;
import java.math.BigDecimal;


/**
 * 一、基本表达式： 字面量表达式、关系，逻辑与算数运算表达式、字符串连接及截取表达式、三目运算及Elivis表达式、正则表达式、括号优先级表达式；
 *
 * 二、类相关表达式： 类类型表达式、类实例化、instanceof表达式、变量定义及引用、赋值表达式、自定义函数、对象属性存取及安全导航表达式、对象方法调用、Bean引用；
 *
 * 三、集合相关表达式： 内联List、内联数组、集合，字典访问、列表，字典，数组修改、集合投影、集合选择；不支持多维内联数组初始化；不支持内联字典定义；
 *
 * 四、其他表达式：模板表达式。
 *
 * 注：SpEL表达式中的关键字是不区分大小写的。
 */
public class SpelTest {


    /**
     * 1、首先准备支持SpEL的Jar包：“org.springframework.expression-3.0.5.RELEASE.jar”将其添加到类路径中。
     *
     * SpEL在求表达式值时一般分为四步，其中第三步可选：首先构造一个解析器，其次解析器解析字符串表达式，在此构造上下文，最后根据上下文得到表达式运算后的值。
     *  原文链接：https://blog.csdn.net/likun557/article/details/107853045
     */
    @Test
    public void test01_HelloWorld(){

        //1、首先构造一个解析器
        ExpressionParser parser = new SpelExpressionParser() ;
        //2、其次解析器解析字符串表达式
        Expression expression = parser.parseExpression("('Hello' + ' World'+'').concat(#end)");
        // 3、构造上下文
        EvaluationContext evaluationContext = new StandardEvaluationContext();
        evaluationContext.setVariable("end","!");
        //4、最后根据上下文得到表达式运算后的值
        String value = expression.getValue(evaluationContext, String.class);
        System.out.println(" 替换结尾 : "+value );

        System.out.println(new BigDecimal("1.1E+2").toPlainString());
    }

}
