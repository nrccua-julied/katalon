package sql

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement
import java.sql.Connection
import groovy.sql.Sql
import java.sql.*

import internal.GlobalVariable

public class DevDB {
	private static Connection connection = null;

	/**
	 * Open and return a connection to database
	 * @param dataFile absolute file path  
	 * @return an instance of java.sql.Connection
	 */
	@Keyword
	def connectDB(String dataFile){
		//Load driver class for your specific database type
		String connectionString = "jdbc:sqlserver://KCSQLTEST01\\SQLOLTP;integratedSecurity=true;databaseName=mco;username=julie.dixon;password=Bolt7676!"
		if(connection != null && !connection.isClosed()){
			connection.close()
		}
		connection = DriverManager.getConnection(connectionString)
		return connection
	}

	/**
	 * execute a SQL query on database
	 * @param queryString SQL query string
	 * @return a reference to returned data collection, an instance of java.sql.ResultSet
	 */
	@Keyword
	def executeQuery(String queryString) {
		Statement stm = connection.createStatement()
		ResultSet rs = stm.executeQuery(queryString)
		return rs
	}

	@Keyword
	def closeDatabaseConnection() {
		if(connection != null && !connection.isClosed()){
			connection.close()
		}
		connection = null
	}

	/**
	 * Execute non-query (usually INSERT/UPDATE/DELETE/COUNT/SUM...) on database	
	 * @param queryString a SQL statement
	 * @return single value result of SQL statement
	 */
	@Keyword
	def execute(String queryString) {
		Statement stm = connection.createStatement()
		boolean result = stm.execute(queryString)
		return result
	}
}
