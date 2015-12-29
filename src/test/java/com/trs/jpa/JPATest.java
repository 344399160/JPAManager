package com.trs.jpa;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.trs.jpa.model.DictBean;
import com.trs.jpa.utils.Criteria;
import com.trs.jpa.utils.Criterion.MatchMode;
import com.trs.jpa.utils.Projections;
import com.trs.jpa.utils.Restrictions;

/**
 * Created by qiaobin on 12/25/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class JPATest {


    @Test
    public void test(){
    	Criteria<DictBean> criteria = new Criteria<DictBean>();
    	//等于
    	criteria.add(Restrictions.eq("dictNum", "001"));
    	//函数用法，其他方法与此种方法写法一致
    	criteria.add(Restrictions.eq(Projections.Length("dictNum"), 6));
    	//like用法， 不传MatchMode默认为ANYWHERE
    	criteria.add(Restrictions.like("dictNum", "001"));
    	criteria.add(Restrictions.like("dictNum", "001", MatchMode.START));
    	//in 的用法
    	List<String> list = new ArrayList<String>();
    	list.add("001");
    	list.add("002");
    	criteria.add(Restrictions.in("dictNum", list));
    	//如果是int类型不要以字符串传入
    	criteria.add(Restrictions.between("orderNum", 1, 5));
    	//or的使用方法， 参数为多参
    	criteria.add(Restrictions.or(Restrictions.eq("dictNum", "001"), Restrictions.eq("dictNum", "002"), Restrictions.eq("dictNum", "003")));
    	//查询
    	//用实现了JPARepository的接口调用    findAll(criteria) 方法
    }

}
