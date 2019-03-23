package com.lzw.headhuntingservice.test;

import com.lzw.headhuntingservice.bean.Applicant;
import net.sf.json.JSONObject;
import org.junit.Test;


public class ObjectToJson {
    Applicant applicant;

    @Test
    public void ApplicantToJson(){
        applicant=new Applicant();
        applicant.setId(1);
        applicant.setName("lin");
        applicant.setGender("man");
        applicant.setAge(22);
        applicant.setEducation("asdads");
        applicant.setTel("13134938543");
        applicant.setResume("以前，广西融水县的从业人员预防性体检都是在县疾控中心进行，按照当地的物价标准收取94元的检查费用。2017年，财政部、国家发改委发文要求，从2017年4月1日起，取消预防性体检收费。\n" +
                "\n" +
                "然而，2019年1月，记者在广西柳州融水县走访时了解到，这里现在仍在收取，每个人148元。\n" +
                "\n" +
                "广西融水苗族自治县疾控中心公共卫生科科长苏冰说，从2017年4月1日开始就已经停止收费了。\n" +
                "\n" +
                "但是，预防性体检收费取消了，可体检时所用的采血、化验等相关检查的针管试剂等耗材仍需要经费维持，而疾控中心又是事业单位，完全靠财政拨款运转，县财政又没有拨付相关的经费。因为没有经费，2018年，融水县疾控中心只能中止了免费的健康体检。体检记录也在2018年2月后就没有了。\n" +
                "\n" +
                "因此，需要健康证的这些特定从业人员只能选择去同样开展体检业务的县级医院来体检。融水县两家医院承揽了特定人员体检的业务，体检合格以后也能发放健康证明，收费148元。");

        JSONObject jsonObject=JSONObject.fromObject(applicant);
        System.out.println(jsonObject);
    }
}
