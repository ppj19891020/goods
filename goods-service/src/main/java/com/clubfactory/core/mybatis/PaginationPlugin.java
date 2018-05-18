package com.clubfactory.core.mybatis;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.ShellRunner;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.util.List;

/**
 * 自定义生成器
 */
public class PaginationPlugin extends PluginAdapter {
	/**
	 * 生成dao
	 */
	@Override
	public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		FullyQualifiedJavaType fqjt = new FullyQualifiedJavaType("com.clubfactory.core.base.BaseDao<" + introspectedTable.getBaseRecordType()	+ ">");
		FullyQualifiedJavaType imp = new FullyQualifiedJavaType("com.clubfactory.core.base.BaseDao");
		interfaze.addSuperInterface(fqjt);// 添加 extends com.xkeshi.wemall.common.base.BaseDao<User>
		interfaze.addImportedType(imp);// 添加import com.xkeshi.wemall.common.base.BaseDao;
		interfaze.getMethods().clear();
		return true;
	}
	
	public boolean validate(List<String> arg0) {
		return true;
	}

}