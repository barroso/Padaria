package br.com.padaria.dao.commons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HipersonicDB
{

	private static final Log log = LogFactory.getLog(HipersonicDB.class);

	private Connection connection;
	private String banco;

	public HipersonicDB(String banco) {
		this.banco = banco;
	}

	public void start() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		Class.forName("org.hsqldb.jdbcDriver").newInstance();
		this.connection = DriverManager.getConnection("jdbc:hsqldb:file:" + banco, "sa", "");
		log.info("Instancia do banco: " + this.banco + " criada com sucesso.");
	}

	public void finish() throws SQLException
	{
		Statement stmt = this.connection.createStatement();
		stmt.execute("SHUTDOWN");
		this.connection.close();
		log.info("Instancia do banco: " + this.banco + " finalizada com sucesso.");
	}

}
