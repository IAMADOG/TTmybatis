/** 
*@ProjectName: mybatis 
*@FileName: MysqlDialect.java 
*@Date: 2016��3��31�� 
*@Copyright: 2016 tianjunwei All rights reserved. 
*/
package com.tianjunwei.page.dialect;

import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.RowBounds;

/**
 * @Title: MysqlDialect.java
 * @Package com.tianjunwei.page.dialect
 * @Description: mysql�ķ�ҳ����
 * @author tianjunwei tiantianjunwei@126.com
 * @date 2016��3��31�� ����11:15:47
 * @version V1.0
 */
public class MysqlDialect extends Dialect {

	public MysqlDialect(MappedStatement mappedStatement, Object parameterObject, RowBounds pageBounds) {
	        super(mappedStatement, parameterObject, pageBounds);
	    }

	/**
	 * ��װ��ҳ��� 
	 * @param sql 
	 * @param offsetName 
	 * @param offset 
	 * @param limitName 
	 * @param limit 
	 * @return String 
	 * @throws
	 */
	protected String getLimitString(String sql, String offsetName, int offset, String limitName, int limit) {
		StringBuffer buffer = new StringBuffer(sql.length() + 20).append(sql);
		if (offset > 0) {
			buffer.append(" limit ?, ?");
			setPageParameter(offsetName, offset, Integer.class);
			setPageParameter(limitName, limit, Integer.class);
		} else {
			buffer.append(" limit ?");
			setPageParameter(limitName, limit, Integer.class);
		}
		return buffer.toString();
	}
}
