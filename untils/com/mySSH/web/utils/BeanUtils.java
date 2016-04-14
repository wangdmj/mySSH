package com.mySSH.web.utils;

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自动生成bean的Dao,DaoImpl,Service,ServiceImpl,Controller
 * 
 * @date 2016-04-14
 * @author wangd
 *
 */
public class BeanUtils {

	// 获取路径
	private static final String ANNOTATION = "/**\r\n * @author wangd\r\n * @date "
			+ getDate() + "\r\n" + " " + "*/" + "\r\n";
	private static final String DAO_PATH = getPath().replace(".", "/") + "/dao";
	private static final String DAO_IMPL_PATH = getPath().replace(".", "/")
			+ "/daoImpl";
	private static final String SERVICE_PATH = getPath().replace(".", "/")
			+ "/service";
	private static final String SERVICE_IMPL_PATH = getPath().replace(".", "/")
			+ "/serviceImpl";
	private static final String CONTROLLER_PATH = getPath().replace(".", "/")
			+ "/controller";
	private static final String DAO_URL = getPath() + ".dao";
	private static final String DAO_IMPL_URL = getPath() + ".daoImpl";
	private static final String SERVICE_URL = getPath() + ".service";
	private static final String SERVICE_IMPL_URL = getPath() + ".serviceImpl";
	private static final String CONTROLLER_URL = getPath() + ".controller";
	private static final String BASE_DAO_NAME = DAO_URL + ".OperateDao";
	private static final String BASE_DAO_IMPL_NAME = DAO_IMPL_URL
			+ ".OperateDaoImpl";
	private static final String BASE_SERVICE_NAME = SERVICE_URL
			+ ".OperateService";
	private static final String BASE_SERVICE_IMPL_NAME = SERVICE_IMPL_URL
			+ ".OperateServiceImpl";

	public static void beanTool(Class<?> c) throws Exception {
		BeanUtils beanUtils = new BeanUtils();
		beanUtils.createBeanDao(c);
		beanUtils.createBeanDaoImpl(c);
		beanUtils.createBeanService(c);
		beanUtils.createBeanServiceImpl(c);
		beanUtils.createController(c);
	}

	/**
	 * 创建Dao
	 * 
	 * @param c
	 * @throws Exception
	 */
	public void createBeanDao(Class<?> c) throws Exception {
		String cName = c.getName();
		String fileName = System.getProperty("user.dir") + "/src/" + DAO_PATH
				+ "/" + getLastChar(cName) + "Dao.java";
		File f = new File(fileName);
		FileWriter fw = new FileWriter(f);
		fw.write("package " + DAO_URL + ";" + "\r\n\r\n" + ANNOTATION
				+ "public interface " + getLastChar(cName) + "Dao extends "
				+ getLastChar(BASE_DAO_NAME) + " {" + "\r\n\r\n" + "}");
		fw.flush();
		fw.close();
		showInfo(fileName);
	}

	/**
	 * 创建DaoImpl
	 * 
	 * @param c
	 * @throws Exception
	 */
	public void createBeanDaoImpl(Class<?> c) throws Exception {
		String cName = c.getName();
		String fileName = System.getProperty("user.dir") + "/src/"
				+ DAO_IMPL_PATH + "/" + getLastChar(cName) + "DaoImpl.java";
		File f = new File(fileName);
		FileWriter fw = new FileWriter(f);
		fw.write("package " + DAO_IMPL_URL + ";" + "\r\n\r\n"
				+ "import org.springframework.stereotype.Repository;" + "\r\n"
				+ "import " + DAO_URL + "." + getLastChar(cName) + "Dao;"
				+ "\r\n\r\n" + ANNOTATION + "@Repository(\""
				+ getLowercaseChar(getLastChar(cName)) + "Dao\")" + "\r\n"
				+ "public class " + getLastChar(cName) + "DaoImpl extends "
				+ getLastChar(BASE_DAO_IMPL_NAME) + " implements "
				+ getLastChar(cName) + "Dao{" + "\r\n\r\n" + "}");
		fw.flush();
		fw.close();
		showInfo(fileName);
	}

	/**
	 * 创建Service
	 * 
	 * @param c
	 * @throws Exception
	 */
	public void createBeanService(Class<?> c) throws Exception {
		String cName = c.getName();
		String fileName = System.getProperty("user.dir") + "/src/"
				+ SERVICE_PATH + "/" + getLastChar(cName) + "Service.java";
		File f = new File(fileName);
		FileWriter fw = new FileWriter(f);
		fw.write("package " + SERVICE_URL + ";" + "\r\n\r\n" + ANNOTATION
				+ "public interface " + getLastChar(cName) + "Service extends "
				+ getLastChar(BASE_SERVICE_NAME) + "{" + "\r\n\r\n" + "}");
		fw.flush();
		fw.close();
		showInfo(fileName);
	}

	/**
	 * 创建ServiceImpl
	 * 
	 * @param c
	 * @throws Exception
	 */
	public void createBeanServiceImpl(Class<?> c) throws Exception {
		String cName = c.getName();
		String fileName = System.getProperty("user.dir") + "/src/"
				+ SERVICE_IMPL_PATH + "/" + getLastChar(cName)
				+ "ServiceImpl.java";
		File f = new File(fileName);
		FileWriter fw = new FileWriter(f);
		fw.write("package " + SERVICE_IMPL_URL + ";" + "\r\n\r\n"
				+ "import javax.annotation.Resource;" + "\r\n\r\n"
				+ "import org.springframework.stereotype.Service;" + "\r\n\r\n"
				+ "import " + DAO_URL + "." + getLastChar(cName) + "Dao;"
				+ "\r\n" + "import " + SERVICE_URL + "." + getLastChar(cName)
				+ "Service;" + "\r\n\r\n" + ANNOTATION + "@Service(\""
				+ getLowercaseChar(getLastChar(cName)) + "Service\")" + "\r\n"
				+ "public class " + getLastChar(cName) + "ServiceImpl extends "
				+ getLastChar(BASE_SERVICE_IMPL_NAME) + " implements "
				+ getLastChar(cName) + "Service{" + "\r\n\r\n" + "    "
				+ "@Resource" + "\r\n" + "    " + "private "
				+ getLastChar(cName) + "Dao "
				+ getLowercaseChar(getLastChar(cName)) + "Dao;" + "\r\n\r\n"
				+ "}");
		fw.flush();
		fw.close();
		showInfo(fileName);
	}

	/**
	 * 创建Controller
	 * 
	 * @param c
	 * @throws Exception
	 */
	public void createController(Class<?> c) throws Exception {
		String cName = c.getName();
		String fileName = System.getProperty("user.dir")
				+ "/EntityAndController/" + CONTROLLER_PATH + "/"
				+ getLastChar(cName) + "Controller.java";
		File f = new File(fileName);
		FileWriter fw = new FileWriter(f);
		fw.write("package "
				+ CONTROLLER_URL
				+ ";"
				+ "\r\n\r\n"
				+ "import java.util.List;"
				+ "\r\n\r\n"
				+ "import javax.annotation.Resource;"
				+ "\r\n\r\n"
				+ "import org.springframework.stereotype.Controller;"
				+ "\r\n"
				+ "import org.springframework.web.bind.annotation.RequestMapping;"
				+ "\r\n"
				+ "import org.springframework.web.bind.annotation.ResponseBody;"
				+ "\r\n\r\n" + "import com.mySSH.respVO.Result;" + "\r\n"
				+ "import com.mySSH.web.entity.Page;" + "\r\n" + "import "
				+ cName + ";" + "\r\n" + "import " + SERVICE_URL + "."
				+ getLastChar(cName) + "Service;" + "\r\n\r\n" + ANNOTATION
				+ "@Controller" + "\r\n" + "public class " + getLastChar(cName)
				+ "Controller {" + "\r\n\r\n" + "    " + "@Resource" + "\r\n"
				+ "    " + "private " + getLastChar(cName) + "Service "
				+ getLowercaseChar(getLastChar(cName)) + "Service;"
				+ "\r\n\r\n" + "    /**" + "\r\n" + "     * 查询所有" + "\r\n"
				+ "     * @return" + "\r\n" + "     */" + "\r\n"
				+ "    @RequestMapping(\""
				+ getLowercaseChar(getLastChar(cName)) + "FindAll\")" + "\r\n"
				+ "    @ResponseBody" + "\r\n" + "    public Result "
				+ getLowercaseChar(getLastChar(cName)) + "FindAll(){" + "\r\n"
				+ "    \tResult result=new Result();" + "\r\n" + "    \ttry {"
				+ "\r\n" + "\t\t\tList<" + getLastChar(cName) + "> "
				+ getLowercaseChar(getLastChar(cName)) + "List="
				+ getLowercaseChar(getLastChar(cName)) + "Service.findAll("
				+ getLastChar(cName) + ".class);" + "\r\n"
				+ "\t\t\tresult.setStatus(\"200\");" + "\r\n"
				+ "\t\t\tresult.setMesg(\"查询成功\");" + "\r\n"
				+ "\t\t\tresult.setData("
				+ getLowercaseChar(getLastChar(cName)) + "List);" + "\r\n"
				+ "\t\t} catch (Exception e) {" + "\r\n"
				+ "\t\t\tresult.setStatus(\"400\");" + "\r\n"
				+ "\t\t\tresult.setMesg(\"查询失败\");" + "\r\n"
				+ "\t\t\tresult.setData(null);" + "\r\n" + "\t\t}" + "\r\n"
				+ "\t\treturn result;" + "\r\n" + "    }" + "\r\n" + "    "
				+ "\r\n" + "    /**" + "\r\n" + "     * 根据id删除"
				+ getLastChar(cName) + "\r\n" + "     * @param id" + "\r\n"
				+ "     * @return" + "\r\n" + "     */" + "\r\n"
				+ "    @RequestMapping(\""
				+ getLowercaseChar(getLastChar(cName)) + "Delete\")" + "\r\n"
				+ "    @ResponseBody" + "\r\n" + "    public Result "
				+ getLowercaseChar(getLastChar(cName)) + "Delete(long id){"
				+ "\r\n" + "    \tResult result=new Result();" + "\r\n"
				+ "    \ttry {" + "\r\n" + "\t\t\t"
				+ getLowercaseChar(getLastChar(cName))
				+ "Service.deleteOperate(" + getLastChar(cName)
				+ ".class, id);" + "\r\n" + "\t\t\tresult.setStatus(\"200\");"
				+ "\r\n" + "\t\t\tresult.setMesg(\"删除成功\");" + "\r\n"
				+ "\t\t\tresult.setData(null);" + "\r\n"
				+ "\t\t} catch (Exception e) {" + "\r\n"
				+ "\t\t\tresult.setStatus(\"400\");" + "\r\n"
				+ "\t\t\tresult.setMesg(\"删除失败\");" + "\r\n"
				+ "\t\t\tresult.setData(null);" + "\r\n" + "\t\t}" + "\r\n"
				+ "\t\treturn result;" + "\r\n" + "    }" + "\r\n\r\n"
				+ "    /**" + "\r\n" + "     * 保存" + getLastChar(cName)
				+ "\r\n" + "     * @param "
				+ getLowercaseChar(getLastChar(cName)) + "\r\n"
				+ "     * @return" + "\r\n" + "     */" + "\r\n"
				+ "    @RequestMapping(\""
				+ getLowercaseChar(getLastChar(cName)) + "Save\")" + "\r\n"
				+ "    @ResponseBody" + "\r\n" + "    public Result "
				+ getLowercaseChar(getLastChar(cName)) + "Save("
				+ getLastChar(cName) + " "
				+ getLowercaseChar(getLastChar(cName)) + "){" + "\r\n"
				+ "    \tResult result=new Result();" + "\r\n" + "    \ttry {"
				+ "\r\n" + "\t\t\t" + getLowercaseChar(getLastChar(cName))
				+ "Service.saveOperate(" + getLowercaseChar(getLastChar(cName))
				+ ");" + "\r\n" + "\t\t\tresult.setStatus(\"200\");" + "\r\n"
				+ "\t\t\tresult.setMesg(\"保存成功\");" + "\r\n"
				+ "\t\t\tresult.setData(null);" + "\r\n"
				+ "\t\t} catch (Exception e) {" + "\r\n"
				+ "\t\t\tresult.setStatus(\"400\");" + "\r\n"
				+ "\t\t\tresult.setMesg(\"保存失败\");" + "\r\n"
				+ "\t\t\tresult.setData(null);" + "\r\n" + "\t\t}" + "\r\n"
				+ "\t\treturn result;" + "\r\n" + "    }" + "\r\n\r\n"
				+ "    /**" + "\r\n" + "     * 分页查询" + "\r\n"
				+ "     * @param pageSize 页面显示条数" + "\r\n"
				+ "     * @param pageCode 当前页号" + "\r\n" + "     * @return"
				+ "\r\n" + "     */" + "\r\n" + "    @RequestMapping(\""
				+ getLowercaseChar(getLastChar(cName)) + "FindPage\")" + "\r\n"
				+ "    @ResponseBody" + "\r\n" + "    public Result "
				+ getLowercaseChar(getLastChar(cName))
				+ "FindPage(String pageSize,String pageCode){" + "\r\n"
				+ "    \tResult result=new Result();" + "\r\n" + "    \tPage<"
				+ getLastChar(cName) + ">pbList=new Page<" + getLastChar(cName)
				+ ">();" + "\r\n"
				+ "    \tint page_code=Integer.valueOf(pageCode);" + "\r\n"
				+ "\t\tint page_size=Integer.valueOf(pageSize);" + "\r\n"
				+ "\t\tpbList.setPageCode(page_code);" + "\r\n"
				+ "\t\tpbList.setPageSize(page_size);" + "\r\n" + "    \ttry {"
				+ "\r\n" + "    \t\tint totalRecord="
				+ getLowercaseChar(getLastChar(cName)) + "Service.findCount("
				+ getLastChar(cName) + ".class);" + "\r\n"
				+ "    \t\tpbList.setTotalRecord(totalRecord);" + "\r\n"
				+ "    \t\t" + "\r\n" + "    \t\tList<" + getLastChar(cName)
				+ "> " + getLowercaseChar(getLastChar(cName)) + "List = "
				+ getLowercaseChar(getLastChar(cName)) + "Service.findLimit("
				+ getLastChar(cName)
				+ ".class, (page_code-1)*page_size,page_size, \"id\");"
				+ "\r\n" + "    \t\tpbList.setBeanList("
				+ getLowercaseChar(getLastChar(cName)) + "List);" + "\r\n"
				+ "    \t\t" + "\r\n" + "\t\t\tresult.setStatus(\"200\");"
				+ "\r\n" + "\t\t\tresult.setMesg(\"查询成功\");" + "\r\n"
				+ "\t\t\tresult.setData(pbList);" + "\r\n"
				+ "\t\t} catch (Exception e) {" + "\r\n"
				+ "\t\t\tresult.setStatus(\"400\");" + "\r\n"
				+ "\t\t\tresult.setMesg(\"查询失败\");" + "\r\n"
				+ "\t\t\tresult.setData(null);" + "\r\n" + "\t\t}" + "\r\n"
				+ "\t\treturn result;" + "\r\n" + "    }" + "\r\n\r\n"
				+ "    /**" + "\r\n" + "     * 根据某字段查找" + "\r\n"
				+ "     * @param name 查找的对象名" + "\r\n"
				+ "     * @param queryName 数据库字段名" + "\r\n" + "     * @return"
				+ "\r\n" + "     */" + "\r\n" + "    @RequestMapping(\""
				+ getLowercaseChar(getLastChar(cName)) + "FindByName\")"
				+ "\r\n" + "    @ResponseBody" + "\r\n" + "    public Result "
				+ getLowercaseChar(getLastChar(cName))
				+ "FindByName(String name,String queryName){" + "\r\n"
				+ "    \tResult result=new Result();" + "\r\n" + "    \ttry {"
				+ "\r\n" + "\t\t\tList<" + getLastChar(cName) + "> "
				+ getLowercaseChar(getLastChar(cName)) + "List="
				+ getLowercaseChar(getLastChar(cName)) + "Service.findByName("
				+ getLastChar(cName) + ".class, name, queryName);" + "\r\n"
				+ "\t\t\tresult.setStatus(\"200\");" + "\r\n"
				+ "\t\t\tresult.setMesg(\"查询成功\");" + "\r\n"
				+ "\t\t\tresult.setData("
				+ getLowercaseChar(getLastChar(cName)) + "List);" + "\r\n"
				+ "\t\t} catch (Exception e) {" + "\r\n"
				+ "\t\t\tresult.setStatus(\"400\");" + "\r\n"
				+ "\t\t\tresult.setMesg(\"查询失败\");" + "\r\n"
				+ "\t\t\tresult.setData(null);" + "\r\n" + "\t\t}" + "\r\n"
				+ "\t\treturn result;" + "\r\n" + "    }" + "\r\n" + "    "
				+ "\r\n" + "    /**" + "\r\n" + "     * 根据某字段模糊查找" + "\r\n"
				+ "     * @param name 查找的对象名" + "\r\n"
				+ "     * @param queryName 数据库字段名" + "\r\n" + "     * @return"
				+ "\r\n" + "     */" + "\r\n" + "    @RequestMapping(\""
				+ getLowercaseChar(getLastChar(cName)) + "FindByVagueName\")"
				+ "\r\n" + "    @ResponseBody" + "\r\n" + "    public Result "
				+ getLowercaseChar(getLastChar(cName))
				+ "FindByVagueName(String name,String queryName){" + "\r\n"
				+ "    \tResult result=new Result();" + "\r\n" + "    \ttry {"
				+ "\r\n" + "\t\t\tList<" + getLastChar(cName) + "> "
				+ getLowercaseChar(getLastChar(cName)) + "List="
				+ getLowercaseChar(getLastChar(cName))
				+ "Service.findByVagueName(" + getLastChar(cName)
				+ ".class, name, queryName);" + "\r\n"
				+ "\t\t\tresult.setStatus(\"200\");" + "\r\n"
				+ "\t\t\tresult.setMesg(\"查询成功\");" + "\r\n"
				+ "\t\t\tresult.setData("
				+ getLowercaseChar(getLastChar(cName)) + "List);" + "\r\n"
				+ "\t\t} catch (Exception e) {" + "\r\n"
				+ "\t\t\tresult.setStatus(\"400\");" + "\r\n"
				+ "\t\t\tresult.setMesg(\"查询失败\");" + "\r\n"
				+ "\t\t\tresult.setData(null);" + "\r\n" + "\t\t}" + "\r\n"
				+ "\t\treturn result;" + "\r\n" + "    }" + "\r\n" + "    "
				+ "\r\n" + "    /**" + "\r\n" + "     * 多条件组合查询" + "\r\n"
				+ "     * @param " + getLowercaseChar(getLastChar(cName))
				+ "\r\n" + "     * @return" + "\r\n" + "     */" + "\r\n"
				+ "    @RequestMapping(\""
				+ getLowercaseChar(getLastChar(cName)) + "FindByManyName\")"
				+ "\r\n" + "    @ResponseBody" + "\r\n" + "    public Result "
				+ getLowercaseChar(getLastChar(cName)) + "FindByManyName("
				+ getLastChar(cName) + " "
				+ getLowercaseChar(getLastChar(cName)) + "){" + "\r\n"
				+ "    \tResult result=new Result();" + "\r\n" + "    \ttry {"
				+ "\r\n" + "\t\t\tList<" + getLastChar(cName) + "> "
				+ getLowercaseChar(getLastChar(cName)) + "List="
				+ getLowercaseChar(getLastChar(cName))
				+ "Service.findMultiConditionCombinationQuery_Accurate("
				+ getLowercaseChar(getLastChar(cName)) + ");" + "\r\n"
				+ "\t\t\tresult.setStatus(\"200\");" + "\r\n"
				+ "\t\t\tresult.setMesg(\"查询成功\");" + "\r\n"
				+ "\t\t\tresult.setData("
				+ getLowercaseChar(getLastChar(cName)) + "List);" + "\r\n"
				+ "\t\t} catch (Exception e) {" + "\r\n"
				+ "\t\t\tresult.setStatus(\"400\");" + "\r\n"
				+ "\t\t\tresult.setMesg(\"查询失败\");" + "\r\n"
				+ "\t\t\tresult.setData(null);" + "\r\n" + "\t\t}" + "\r\n"
				+ "\t\treturn result;" + "\r\n" + "    }" + "\r\n" + "    "
				+ "\r\n" + "    /**" + "\r\n" + "     * 多条件组合模糊查询" + "\r\n"
				+ "     * @param " + getLowercaseChar(getLastChar(cName))
				+ "\r\n" + "     * @return" + "\r\n" + "     */" + "\r\n"
				+ "    @RequestMapping(\""
				+ getLowercaseChar(getLastChar(cName))
				+ "FindByManyVagueName\")" + "\r\n" + "    @ResponseBody"
				+ "\r\n" + "    public Result "
				+ getLowercaseChar(getLastChar(cName)) + "FindByManyVagueName("
				+ getLastChar(cName) + " "
				+ getLowercaseChar(getLastChar(cName)) + "){" + "\r\n"
				+ "    \tResult result=new Result();" + "\r\n" + "    \ttry {"
				+ "\r\n" + "\t\t\tList<" + getLastChar(cName) + "> "
				+ getLowercaseChar(getLastChar(cName)) + "List="
				+ getLowercaseChar(getLastChar(cName))
				+ "Service.findMultiConditionCombinationQuery_Vague("
				+ getLowercaseChar(getLastChar(cName)) + ");" + "\r\n"
				+ "\t\t\tresult.setStatus(\"200\");" + "\r\n"
				+ "\t\t\tresult.setMesg(\"查询成功\");" + "\r\n"
				+ "\t\t\tresult.setData("
				+ getLowercaseChar(getLastChar(cName)) + "List);" + "\r\n"
				+ "\t\t} catch (Exception e) {" + "\r\n"
				+ "\t\t\tresult.setStatus(\"400\");" + "\r\n"
				+ "\t\t\tresult.setMesg(\"查询失败\");" + "\r\n"
				+ "\t\t\tresult.setData(null);" + "\r\n" + "\t\t}" + "\r\n"
				+ "\t\treturn result;" + "\r\n" + "    }" + "\r\n" + "    "
				+ "\r\n" + "    /**" + "\r\n" + "     * 多条件组合查询,返回分页" + "\r\n"
				+ "     * @param " + getLowercaseChar(getLastChar(cName))
				+ "\r\n" + "     * @param pageSize 页面显示条数  " + "\r\n"
				+ "     * @param pageCode 当前页号    " + "\r\n" + "     * @return"
				+ "\r\n" + "     */" + "\r\n" + "    @RequestMapping(\""
				+ getLowercaseChar(getLastChar(cName))
				+ "FindByManyNameReturnPage\")" + "\r\n" + "    @ResponseBody"
				+ "\r\n" + "    public Result "
				+ getLowercaseChar(getLastChar(cName))
				+ "FindByManyNameReturnPage(" + getLastChar(cName) + " "
				+ getLowercaseChar(getLastChar(cName))
				+ ",String pageSize,String pageCode){" + "\r\n"
				+ "    \tResult result=new Result();" + "\r\n" + "    \tPage<"
				+ getLastChar(cName) + ">pbList=new Page<" + getLastChar(cName)
				+ ">();" + "\r\n"
				+ "    \tint page_code=Integer.valueOf(pageCode);" + "\r\n"
				+ "\t\tint page_size=Integer.valueOf(pageSize);" + "\r\n"
				+ "\t\tpbList.setPageCode(page_code);" + "\r\n"
				+ "\t\tpbList.setPageSize(page_size);" + "\r\n" + "    \ttry {"
				+ "\r\n" + "    \t\tint totalRecord="
				+ getLowercaseChar(getLastChar(cName))
				+ "Service.findMultiConditionCombinationQuery_Accurate_Count("
				+ getLowercaseChar(getLastChar(cName)) + ");" + "\r\n"
				+ "    \t\tpbList.setTotalRecord(totalRecord);" + "\r\n"
				+ "    \t\t" + "\r\n" + "    \t\tList<" + getLastChar(cName)
				+ "> " + getLowercaseChar(getLastChar(cName)) + "List = "
				+ getLowercaseChar(getLastChar(cName))
				+ "Service.findMultiConditionCombinationQuery_Accurate_Limit("
				+ getLowercaseChar(getLastChar(cName))
				+ ", (page_code-1)*page_size,page_size);" + "\r\n"
				+ "    \t\tpbList.setBeanList("
				+ getLowercaseChar(getLastChar(cName)) + "List);" + "\r\n"
				+ "    \t\t" + "\r\n" + "\t\t\tresult.setStatus(\"200\");"
				+ "\r\n" + "\t\t\tresult.setMesg(\"查询成功\");" + "\r\n"
				+ "\t\t\tresult.setData(pbList);" + "\r\n"
				+ "\t\t} catch (Exception e) {" + "\r\n"
				+ "\t\t\tresult.setStatus(\"400\");" + "\r\n"
				+ "\t\t\tresult.setMesg(\"查询失败\");" + "\r\n"
				+ "\t\t\tresult.setData(null);" + "\r\n" + "\t\t}" + "\r\n"
				+ "\t\treturn result;" + "\r\n" + "    }" + "\r\n" + "    "
				+ "\r\n" + "    /**" + "\r\n" + "     * 多条件组合模糊查询,返回分页"
				+ "\r\n" + "     * @param "
				+ getLowercaseChar(getLastChar(cName)) + "\r\n"
				+ "     * @param pageSize 页面显示条数  " + "\r\n"
				+ "     * @param pageCode 当前页号    " + "\r\n" + "     * @return"
				+ "\r\n" + "     */" + "\r\n" + "    @RequestMapping(\""
				+ getLowercaseChar(getLastChar(cName))
				+ "FindByManyVagueNameReturnPage\")" + "\r\n"
				+ "    @ResponseBody" + "\r\n" + "    public Result "
				+ getLowercaseChar(getLastChar(cName))
				+ "FindByManyVagueNameReturnPage(" + getLastChar(cName) + " "
				+ getLowercaseChar(getLastChar(cName))
				+ ",String pageSize,String pageCode){" + "\r\n"
				+ "    \tResult result=new Result();" + "\r\n" + "    \tPage<"
				+ getLastChar(cName) + ">pbList=new Page<" + getLastChar(cName)
				+ ">();" + "\r\n"
				+ "    \tint page_code=Integer.valueOf(pageCode);" + "\r\n"
				+ "\t\tint page_size=Integer.valueOf(pageSize);" + "\r\n"
				+ "\t\tpbList.setPageCode(page_code);" + "\r\n"
				+ "\t\tpbList.setPageSize(page_size);" + "\r\n" + "    \ttry {"
				+ "\r\n" + "    \t\tint totalRecord="
				+ getLowercaseChar(getLastChar(cName))
				+ "Service.findMultiConditionCombinationQuery_Vague_Count("
				+ getLowercaseChar(getLastChar(cName)) + ");" + "\r\n"
				+ "    \t\tpbList.setTotalRecord(totalRecord);" + "\r\n"
				+ "    \t\t" + "\r\n" + "    \t\tList<" + getLastChar(cName)
				+ "> " + getLowercaseChar(getLastChar(cName)) + "List = "
				+ getLowercaseChar(getLastChar(cName))
				+ "Service.findMultiConditionCombinationQuery_Vague_Limit("
				+ getLowercaseChar(getLastChar(cName))
				+ ", (page_code-1)*page_size,page_size);" + "\r\n"
				+ "    \t\tpbList.setBeanList("
				+ getLowercaseChar(getLastChar(cName)) + "List);" + "\r\n"
				+ "    \t\t" + "\r\n" + "\t\t\tresult.setStatus(\"200\");"
				+ "\r\n" + "\t\t\tresult.setMesg(\"查询成功\");" + "\r\n"
				+ "\t\t\tresult.setData(pbList);" + "\r\n"
				+ "\t\t} catch (Exception e) {" + "\r\n"
				+ "\t\t\tresult.setStatus(\"400\");" + "\r\n"
				+ "\t\t\tresult.setMesg(\"查询失败\");" + "\r\n"
				+ "\t\t\tresult.setData(null);" + "\r\n" + "\t\t}" + "\r\n"
				+ "\t\treturn result;" + "\r\n" + "    }" + "\r\n" +

				"\r\n\r\n" + "}");
		fw.flush();
		fw.close();
		showInfo(fileName);
	}

	/**
	 * 截取Bean的类名
	 * 
	 * @param str
	 * @return
	 */
	public String getLastChar(String str) {
		if ((str != null) && (str.length() > 0)) {
			int dot = str.lastIndexOf('.');
			if ((dot > -1) && (dot < str.length() - 1)) {
				return str.substring(dot + 1);
			}
		}
		return str;
	}

	/**
	 * 将取Bean的类名的第一个字母变为小写
	 * 
	 * @param str
	 * @return
	 */
	public String getLowercaseChar(String str) {
		return str.substring(0, 1).toLowerCase() + str.substring(1);
	}

	public void showInfo(String info) {
		System.out.println("创建文件：" + info + "成功！");
	}

	/**
	 * 获取系统时间
	 * 
	 * @return
	 */
	public static String getDate() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return simpleDateFormat.format(new Date());
	}

	/**
	 * 获取上级文件夹路径路径
	 * 
	 * @return
	 */
	public static String getPath() {
		BeanUtils beanUtils = new BeanUtils();
		String s = beanUtils.getClass().getPackage().getName();
		int p = s.lastIndexOf(".");
		return s.substring(0, p);
	}
}
