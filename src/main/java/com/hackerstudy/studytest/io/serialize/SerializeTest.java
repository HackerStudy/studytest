package com.hackerstudy.studytest.io.serialize;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * @class: SerializeTest
 * @description:
 * @author: HackerStudy
 * @date: 2020-06-04 12:35
 */
public class SerializeTest {

    /**
     * @description: 序列化对象
     * @param: [person]
     * @return: java.lang.String
     * @auther: HackerStudy
     * @date: 2020-06-04 12:40
     * @throws
     */
    public static String serialize(Person person){
        XStream xStream=new XStream(new DomDriver());
        xStream.alias("person",Person.class);
        String personXml = xStream.toXML(person);
        return personXml;
    }

    /**
     * @description: 反序列化
     * @param: [personXml]
     * @return: com.hackerstudy.studytest.io.serialize.Person
     * @auther: HackerStudy
     * @date: 2020-06-04 12:39
     * @throws
     */
    public static Person deSerialize(String personXml){
        XStream xStream=new XStream(new DomDriver());
        xStream.alias("person",Person.class);
        Person person=(Person) xStream.fromXML(personXml);
        return person;
    }

    public static void main(String[] args) {
        Person srcPerson= new Person();
        srcPerson.setName("张三");
        srcPerson.setAge(11);
        srcPerson.setDesc("简介");
        String personXml=serialize(srcPerson);
        System.out.println(personXml);
        Person person=deSerialize(personXml);
        System.out.println(person.toString());
    }
}
