package com.bdqnsxt.oa.component.db;


/*
 * 封装sql查询条件的表达式
 */
public class Expression {
	/**
	 * 查询方式常量
	 */
	public static String OP_EQ = "=";             //相等
	public static String OP_NE = "!=";            //不相等
	public static String OP_GT = ">";             //大于
	public static String OP_LT = "<";             //小于
	public static String OP_GE = ">=";	          //大于等于
	public static String OP_LE = "<=";            //小于等于
	public static String OP_RLIKE = "rlike";      //右like 例：where field like "a%"
	public static String OP_LLIKE = "llike";      //左like 例：where field like "%a"
	public static String OP_LIKE = "like";        //like   例：where field like "%a%"
	public static String OP_IN = "in";	          //in查询   例：where field in ("1","2")
	public static String OP_NOTIN = "not in";	          //in查询   例：where field not in ("1","2")
	public static String OP_INQUERY = "inQuery";  //语句查询 例 where a  b_code in（select code from table_b）
	public static String OP_NOTINQUERY = "not inQuery";//例例 where a  b_code not in（select code from table_b）
	public static String OP_ISNULL = "is null";		// 查找空值
	public static String OP_ISNOTNULL = "is not null";	//查找非空值
	public static String SEPSRATOR =",";          //value值的分隔符
	
	public static String OP_META = "meta";
	/**
	 *  空字符串
	 */
	public static String EMPTY_VALUE = "$EMPTY$";
	/**
	 * 要查询的字段
	 */
	private String name;
	
	/**
	 * 查询方式
	 */
	private String op;
	
	/**
	 * 匹配的值
	 */
	private Object value;
	
	
	/**
	 * 空构造方法
	 */
	public Expression(){
		
	}
	/**
	 * 构造方法 
	 */
	public Expression(String name ,Object value){
		this.name = name;
		this.op = OP_EQ;
		this.value = value;
	}
	
	/**
	 * 构造方法 
	 */
	public Expression(String name,String op,Object value){
		this.name = name;
		this.op =op;
		this.value = value;
	}
	
	
	/**
	 * 下面是getters 和setters 
	 */
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
