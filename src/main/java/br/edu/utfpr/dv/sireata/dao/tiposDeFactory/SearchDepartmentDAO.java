package br.edu.utfpr.dv.sireata.dao.tiposDeFactory;

import br.edu.utfpr.dv.sireata.dao.DepartamentoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class SearchDepartmentDAO implements BuscarPorId {
    @Override
    public void tryConnection() {

        int id;
        Connection conn ;
        PreparedStatement stmt;
        ResultSet rs ;

        public AtaDAO(int id, Connection conn, Statement stmt, ResultSet rs) {
            this.id = id;
            this.conn = conn;
            this.stmt - stmt;
            this.rs = rs;
        }

        try{
            conn = ConnectionDAO.getInstance().getConnection();
            stmt = conn.prepareStatement(
                    "SELECT departamentos.*, campus.nome AS nomeCampus " +
                            "FROM departamentos INNER JOIN campus ON campus.idCampus=departamentos.idCampus " +
                            "WHERE idDepartamento = ?");

            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            if(rs.next()){
                return this.carregarObjeto(rs);
            }else{
                return null;
            }
        }finally{
            if((rs != null) && !rs.isClosed())
                rs.close();
            if((stmt != null) && !stmt.isClosed())
                stmt.close();
            if((conn != null) && !conn.isClosed())
                conn.close();
        }
    }
}
