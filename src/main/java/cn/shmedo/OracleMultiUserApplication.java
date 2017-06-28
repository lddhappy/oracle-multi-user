package cn.shmedo;

import cn.shmedo.config.CommonDB;
import cn.shmedo.config.ContextHolder;
import cn.shmedo.data.ProjDbInit;
import cn.shmedo.data.dao.TBaseProjInfoDao;
import cn.shmedo.data.dao.TBaseSensorAttriDao;
import cn.shmedo.data.model.TBaseSensorAttri;
import cn.shmedo.db.common.TBaseProjInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootApplication
public class OracleMultiUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(OracleMultiUserApplication.class, args);
		TBaseProjInfoDao bean=ContextHolder.getContext().getBean(TBaseProjInfoDao.class);
		List<TBaseProjInfo> pis= bean.getAllProj();
		ProjDbInit.init(pis);


		TBaseSensorAttriDao attriDao=ContextHolder.getContext().getBean(TBaseSensorAttriDao.class);
		List<TBaseSensorAttri>attris1= attriDao.getSensors(pis.get(0).getId());
		List<TBaseSensorAttri>attris2= attriDao.getSensors(pis.get(1).getId());
		String t="";
	}
}
