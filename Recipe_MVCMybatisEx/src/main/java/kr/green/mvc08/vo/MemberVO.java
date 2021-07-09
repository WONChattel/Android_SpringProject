package kr.green.mvc08.vo;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
public class MemberVO {
	private String id;
	private String password;
	private String address;

}
