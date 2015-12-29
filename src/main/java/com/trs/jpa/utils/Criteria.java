package com.trs.jpa.utils;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang.StringUtils;
import org.springframework.data.jpa.domain.Specification;
/** 
 * 定义一个查询条件容器 
 * 
 * @param <T> 
 */  
public class Criteria<T> implements Specification<T>{
	//查询条件容器
	private List<Criterion> criterions = new ArrayList<Criterion>();  
	//倒序查询条件
	private String orderByDESC;
	//升序查询条件
	private String orderByASC;
	//group查询条件
	private String groupBy;
	  
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query,  
            CriteriaBuilder builder) {  
    	if(!StringUtils.isEmpty(orderByASC))
    		query.orderBy(builder.desc(root.get(getOrderByASC())));
    	if(!StringUtils.isEmpty(orderByDESC))
    		query.orderBy(builder.desc(root.get(getOrderByDESC())));
    	if(!StringUtils.isEmpty(groupBy))
    		query.groupBy(root.get(getGroupBy()));
        if (!criterions.isEmpty()) {  
            List<Predicate> predicates = new ArrayList<Predicate>();  
            for(Criterion c : criterions){  
                predicates.add(c.toPredicate(root, query,builder));  
            }
            // 将所有条件用 and 联合起来  
            if (predicates.size() > 0) {  
                return builder.and(predicates.toArray(new Predicate[predicates.size()]));  
            }  
        }  
        return builder.conjunction();  
    }  
    /** 
     * 增加简单条件表达式 
     * @Methods Name add 
     * 
     */  
    public void add(Criterion criterion){  
        if(criterion!=null){  
            criterions.add(criterion);  
        }  
    }  
    
    public void orderByDESC(String col){
    	setOrderByDESC(col);
    }
    
    public void orderByASC(String col){
    	setOrderByASC(col);
    }
    
    public void groupBy(String col){
    	setGroupBy(col);
    }
    
    
	public String getOrderByDESC() {
		return orderByDESC;
	}
	private void setOrderByDESC(String orderByDESC) {
		this.orderByDESC = orderByDESC;
	}
	public String getOrderByASC() {
		return orderByASC;
	}
	private void setOrderByASC(String orderByASC) {
		this.orderByASC = orderByASC;
	}
	public String getGroupBy() {
		return groupBy;
	}
	private void setGroupBy(String groupBy) {
		this.groupBy = groupBy;
	}
    
}
