package com.trs.jpa.utils;

import java.util.Collection;

import com.trs.jpa.utils.Criterion.MatchMode;


/** 
 * 条件构造器 
 * 用于创建条件表达式 
 */  
public class Restrictions {
	/** 
     * 等于 
     * @param fieldName : 匹配字段 
     * @param value : 匹配值
     * @return 
     */  
    public static SimpleExpression eq(String fieldName, Object value) {  
        if(value.equals(null))return null;  
        return new SimpleExpression (fieldName, value, Criterion.Operator.EQ);  
    }  
    
    /** 
     * 等于 （函数条件查询）
     * @param projection : Projection查询条件(Projections.MAX\SUM\AVG...)
     * @param value : 匹配值
     * @return 
     */  
    public static ProjectionExpression eq(Projection projection, Object value) {  
    	if(value.equals(null))return null;
    	return new ProjectionExpression (projection.getCol(), value, projection.getType(), Criterion.Operator.EQ);  
    }  
      
    /** 
     * 不等于 
     * @param fieldName : 匹配字段 
     * @param value : 匹配值
     * @return 
     */  
    public static SimpleExpression ne(String fieldName, Object value) {  
        if(value.equals(null))return null;  
        return new SimpleExpression (fieldName, value, Criterion.Operator.NE);  
    }  
    
    /** 
     * 不等于（函数条件查询） 
     * @param projection : Projection查询条件(Projections.MAX\SUM\AVG...)
     * @param value : 匹配值
     * @return 
     */  
    public static ProjectionExpression ne(Projection projection, Object value) {  
    	if(value.equals(null))return null;  
    	return new ProjectionExpression (projection.getCol(), value, projection.getType(), Criterion.Operator.NE);  
    }  
  
    /** 
     * 模糊匹配 
     * @param fieldName : 匹配字段 
     * @param value : 匹配值 
     * @return 
     */  
    public static SimpleExpression like(String fieldName, String value) {  
        if(value.equals(null))return null;  
        return new SimpleExpression (fieldName, value, Criterion.Operator.LIKE);  
    }  
    
    /** 
     * 模糊匹配 （函数条件查询）
     * @param projection : Projection查询条件(Projections.MAX\SUM\AVG...)
     * @param value : 匹配值
     * @return 
     */  
    public static ProjectionExpression like(Projection projection, String value) {  
    	if(value.equals(null))return null;  
    	return new ProjectionExpression (projection.getCol(), value, projection.getType(), Criterion.Operator.LIKE);
    }  
  
    /** 
     *  自定义模式模糊匹配
     * @param fieldName : 匹配字段
     * @param value : 匹配值
     * @param matchMode : 匹配方式(MatchMode.START\END\ANYWHERE)
     * @return 
     */  
    public static SimpleExpression like(String fieldName, String value,  
            MatchMode matchMode) {  
        if(value.equals(null))return null;  
        return new SimpleExpression(fieldName, value, matchMode, Criterion.Operator.LIKE);  
    }  
    
    /** 
     *  自定义模式模糊匹配（函数条件查询）
     * @param projection : Projection查询条件(Projections.MAX\SUM\AVG...)
     * @param value  : 匹配值
     * @param matchMode : 匹配方式(MatchMode.START\END\ANYWHERE)
     * @return 
     */  
    public static ProjectionExpression like(Projection projection, String value,  
    		MatchMode matchMode) {  
    	if(value.equals(null))return null;  
    	return new ProjectionExpression (projection.getCol(), value, projection.getType(), Criterion.Operator.LIKE, matchMode);  
    }  
  
    /** 
     * 大于 
     * @param fieldName : 匹配字段 
     * @param value : 匹配值 
     * @return 
     */  
    public static SimpleExpression gt(String fieldName, Object value) {  
        if(value.equals(null))return null;  
        return new SimpleExpression (fieldName, value, Criterion.Operator.GT);  
    }  
    
    /** 
     * 大于（函数条件查询） 
     * @param projection : Projection查询条件(Projections.MAX\SUM\AVG...) 
     * @param value : 匹配值
     * @return 
     */  
    public static ProjectionExpression gt(Projection projection, Object value) {  
    	if(value.equals(null))return null;  
    	return new ProjectionExpression (projection.getCol(), value, projection.getType(), Criterion.Operator.GT);  
    }  
  
    /** 
     * 小于 
     * @param fieldName : 匹配字段 
     * @param value : 匹配值 
     * @return 
     */  
    public static SimpleExpression lt(String fieldName, Object value) {  
        if(value.equals(null))return null;  
        return new SimpleExpression (fieldName, value, Criterion.Operator.LT);  
    }  
    
    /** 
     * 小于（函数条件查询）  
     * @param projection : Projection查询条件(Projections.MAX\SUM\AVG...)  
     * @param value : 匹配值 
     * @return 
     */  
    public static ProjectionExpression lt(Projection projection, Object value) {  
    	if(value.equals(null))return null;  
    	return new ProjectionExpression (projection.getCol(), value, projection.getType(), Criterion.Operator.LT);  
    }  
  
    /** 
     * 大于等于 
     * @param fieldName : 匹配字段 
     * @param value : 匹配值 
     * @return 
     */  
    public static SimpleExpression lte(String fieldName, Object value) {  
        if(value.equals(null))return null;  
        return new SimpleExpression (fieldName, value, Criterion.Operator.GTE);  
    }  
    
    /** 
     * 大于等于（函数条件查询） 
     * @param projection : Projection查询条件(Projections.MAX\SUM\AVG...) 
     * @param value : 匹配值
     * @return 
     */  
    public static ProjectionExpression lte(Projection projection, Object value) {  
    	if(value.equals(null))return null;  
    	return new ProjectionExpression (projection.getCol(), value, projection.getType(), Criterion.Operator.LTE);  
    }  
  
    /** 
     * 小于等于 
     * @param fieldName : 匹配字段
     * @param value : 匹配值
     * @return 
     */  
    public static SimpleExpression gte(String fieldName, Object value) {  
        if(value.equals(null))return null;  
        return new SimpleExpression (fieldName, value, Criterion.Operator.LTE);  
    }  
    
    /** 
     * 小于等于 
     * @param projection : Projection查询条件(Projections.MAX\SUM\AVG...) 
     * @param value : 匹配值
     * @return 
     */ 
    public static ProjectionExpression gte(Projection projection, Object value) {  
    	if(value.equals(null))return null;  
    	return new ProjectionExpression (projection.getCol(), value, projection.getType(), Criterion.Operator.GTE);  
    }  
  
    
    /** 
     * 或者 
     * @param criterions 
     * @return 
     */  
    public static LogicalExpression or(Criterion... criterions){  
        return new LogicalExpression(criterions, Criterion.Operator.OR);  
    }  
    
    
    /** 
     * 区间 
     * @param column : 匹配字段
     * @param1 val1 左区间 
     * @param2 val2 右区间
     * @return 
     */ 
    public static LogicalExpression between(String column, Object val1, Object val2){
    	return new LogicalExpression(column, val1, val2, Criterion.Operator.BETWEEN);
    }
    
    
    
    
    /** 
     * 包含于 
     * @param fieldName : 匹配字段
     * @param value : 匹配值
     * @return 
     */  
    @SuppressWarnings("rawtypes")  
    public static LogicalExpression in(String fieldName, Collection value) {  
        SimpleExpression[] ses = new SimpleExpression[value.size()];  
        int i=0;  
        for(Object obj : value){  
            ses[i]=new SimpleExpression(fieldName,obj,Criterion.Operator.EQ);  
            i++;  
        }  
        return new LogicalExpression(ses,Criterion.Operator.OR);  
    }  
}
