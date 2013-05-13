package assignment.scope;

/**
* Interface for putting records in the symbol table
* 
* @author Margarita Litkevych
* @author Tymur Maryokhin
* 
*/
public interface Record {

	String INT = "int";
	String BOOLEAN = "boolean";
	String ARRAY_TYPE = "ARRAY_TYPE";

	String TRUE = "true";
	String FALSE = "false";

	String MAIN = "main";

	int CLASS = 101;
	int METHOD = 102;
	int VARIABLE = 103;

	String getType();

	String getName();
	
	int getRecordType();

	void setType(String type);
}
