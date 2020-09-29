package br.edu.utfpr.dv.sireata.dao.tiposDeFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface BuscarPorId {

    public default void tryConnection() throws SQLException {
    }


}
