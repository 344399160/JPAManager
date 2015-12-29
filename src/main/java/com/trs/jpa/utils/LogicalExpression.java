package com.trs.jpa.utils;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.util.StringUtils;

/** 
 * 逻辑条件表达式 用于复杂条件时使用，如但属性多对应值的OR查询等 
 * 
 */  
public class LogicalExpression implements Criterion {
	private Criterion[] criterion;  // 逻辑表达式中包含的表达式  
	private Operator operator;      //计算符
	private String col;
	private Object exp1;
	private Object exp2;
	  
    public LogicalExpression(Criterion[] criterions, Operator operator) {  
        this.criterion = criterions;  
        this.operator = operator;  
    }  
    
    //between用构造方法
    public LogicalExpression(String col, Object exp1, Object exp2, Operator operator){
    	this.col = col;
    	this.exp1 = exp1;
    	this.exp2 = exp2;
    	this.operator = operator;
    	this.criterion = null;
    }
    
    public Predicate toPredicate(Root<?> root, CriteriaQuery<?> query,  
            CriteriaBuilder builder) {  
        List<Predicate> predicates = new ArrayList<Predicate>();  
        if(!StringUtils.isEmpty(criterion))
	        for(int i=0;i<this.criterion.length;i++){  
	            predicates.add(this.criterion[i].toPredicate(root, query, builder));  
	        }  
        switch (operator) {  
        case OR:  
            return builder.or(predicates.toArray(new Predicate[predicates.size()]));  
        case AND:  
            return builder.and(predicates.toArray(new Predicate[predicates.size()]));
        case BETWEEN:
        	Expression expression = root.get(col);
        	return builder.between(expression, (Comparable) exp1, (Comparable) exp2);
        default:  
            return null;  
        }  
    }

	public String getCol() {
		return col;
	}

	public Object getExp1() {
		return exp1;
	}

	public Object getExp2() {
		return exp2;
	}  
}
