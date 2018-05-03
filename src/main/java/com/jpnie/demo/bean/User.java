package com.jpnie.demo.bean;

import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.XmlInlineBinaryData;

/**
 * Created by njp on 18/5/3.
 */
@ToString
@Data
public class User {
    private String userName;
    private String email;

}

