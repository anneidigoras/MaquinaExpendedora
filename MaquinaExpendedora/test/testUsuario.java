

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import LD.ConexionSql;
import junit.framework.TestCase;

public class testUsuario extends TestCase {

    public void testDBRegistryConnection() {
       // Connection con =  ConexionSql.getLastError();
       // assertNotNull(con);
    }

    public void testTableQuery() throws SQLException {
        //Connection con =  DBRegistry.getUniqueInstance().getDBConnection();
      //  PreparedStatement dbStatement = con.prepareStatement("SELECT COUNT(*) FROM `singleTask`");
     //   assertEquals("should be 1 for successful query", 1, dbStatement.executeQuery());
    }}