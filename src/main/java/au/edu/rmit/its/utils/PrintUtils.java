package au.edu.rmit.its.utils;

import com.teratext.dbs.record.OctetAlignedData;
import com.teratext.dbs.record.Record;
import com.teratext.dbs.support.Utils;

public class PrintUtils {
	
	/**
     * Output whitespace indentation for displaying record data.
     * 
     * @param indent the level of indentation to output
     */
    private static void indent(int indent)
    {
        for (int i = 0; i < indent; i++)
        {
            System.out.print("    ");
        }
    }
    
	/**
     * Display the record.
     * 
     * @param record the record to display
     * @param recstructName the recstruct name for the record
     * @param indent the level of indentation for display
     */
    public static void printRecord(Record record, String recstructName, int indent)
    {
        indent(indent);
        System.out.println("Name: " + recstructName + " (");
        for (String field : record.getFieldNames())
        {
            indent(indent + 1);
            System.out.println("Name: " + field);
            indent(indent + 1);
            
            Record.FieldType fieldType = record.getFieldType(field);
            switch (fieldType)
            {
                case INTEGER:
                    System.out.println("Type: Integer");
                    indent(indent + 1);
                    System.out.println("Value: " + record.getInteger(field));
                    break;
                case FLOAT:
                    System.out.println("Type: Float");
                    indent(indent + 1);
                    System.out.println("Value: " + record.getFloat(field));
                    break;
                case STRING:
                    System.out.println("Type: String");
                    indent(indent + 1);
                    System.out.println("Value: " + record.getString(field));
                    break;
                case BINARY:
                    System.out.println("Type: Binary");
                    indent(indent + 1);
                    System.out.println("Value: " + Utils.escapeToString(record.getBinary(field)));
                    break;
                case BOOLEAN:
                    System.out.println("Type: Boolean");
                    indent(indent + 1);
                    System.out.println("Value: " + record.getBoolean(field));
                    break;
                case SGMLDOCUMENT:
                    System.out.println("Type: SgmlDocument");
                    indent(indent + 1);
                    System.out.println("Value: " + record.getSgmlDocument(field).getDocumentString());
                    break;
                case UNISGMLDOCUMENT:
                    System.out.println("Type: UniSgmlDocument");
                    indent(indent + 1);
                    System.out.println("Value: " + record.getUniSgmlDocument(field).getDocumentString());
                    break;                    
                case DATETIME:
                    System.out.println("Type: DateTime");
                    indent(indent + 1);
                    System.out.println("Value: " + record.getDateTime(field).toString());
                    break;
                case DURATION:
                    System.out.println("Type: Duration");
                    indent(indent + 1);
                    System.out.println("Value: " + record.getDuration(field).toString());
                    break;
                case RECORD:
                    System.out.println("Type: Record");
                    indent(indent + 1);
                    System.out.println("Value:");
                    printRecord(record.getRecord(field), field, indent + 2);
                    break;
                case OCTETALIGNEDDATA:
                    System.out.println("Type: OctetAlignedData/MARC");
                    indent(indent + 1);
                    OctetAlignedData oad = record.getOctetAlignedData(field);
                    //System.out.println("Oid: " + oad.getOid().getDottedIntString());
                    System.out.println("Value: " + Utils.escapeToString(oad.getData()));
                    break;
            }
            System.out.println("");
        }
        indent(indent);
        System.out.println(")");
    }
}
