package Modelo.Carreras;

import Modelo.*;
import Controlador.Carreras.clsCarrera;
import Controlador.clsBitacora;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarreraDAO {

    private static final String SQL_SELECT =
            "SELECT codigo_carrera, nombre_carrera, codigo_facultad, estatus_carrera FROM carreras";

    private static final String SQL_INSERT =
            "INSERT INTO carreras(nombre_carrera, codigo_facultad, estatus_carrera) VALUES(?, ?, ?)";

    private static final String SQL_UPDATE =
            "UPDATE carreras SET nombre_carrera=?, codigo_facultad=? , estatus_carrera=? WHERE codigo_carrera=?";

    private static final String SQL_DELETE =
            "DELETE FROM carreras WHERE codigo_carrera=?";

    private static final String SQL_SELECT_ID =
            "SELECT codigo_carrera, nombre_carrera, codigo_facultad, estatus_carrera FROM carreras WHERE codigo_carrera=?";


    private static final String SQL_INSERT_BITACORA =
            "INSERT INTO bitacora(usuid, aplcodigo, bitfecha, bitip, bitequipo, bitaccion) VALUES(?, ?, ?, ?, ?, ?)";

    private static final String SQL_SELECT_BITACORA =
            "SELECT bitcodigo, usuid, aplcodigo, bitfecha, bitip, bitequipo, bitaccion FROM bitacora";

    private static final String SQL_UPDATE_BITACORA =
            "UPDATE bitacora SET usuid=?, aplcodigo=?, bitfecha=?, bitip=?, bitequipo=?, bitaccion=? WHERE bitcodigo=?";

    private static final String SQL_DELETE_BITACORA =
            "DELETE FROM bitacora WHERE bitcodigo=?";


    
    public List<clsCarrera> obtenerCarreras(clsBitacora bitacora) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<clsCarrera> lista = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
//Esquema completo
            while (rs.next()) {
                clsCarrera p = new clsCarrera();
                p.setCodigoCarrera(rs.getInt("codigo_carrera"));
                p.setNombreCarrera(rs.getString("nombre_carrera"));
                p.setCodigoFacultad(rs.getString("codigo_facultad"));
                p.setEstatusCarrera(rs.getString("estatus_carrera"));
                lista.add(p);
            }

            bitacora.setBitaccion("SELECT carreras");
            insertarBitacora(bitacora);

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return lista;
    }

    public int insertarCarrera(clsCarrera carrera, clsBitacora bitacora) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

            stmt.setString(1, carrera.getNombreCarrera());
            stmt.setString(2, carrera.getCodigoFacultad());
            stmt.setString(3, carrera.getEstatusCarrera());

            rows = stmt.executeUpdate();

            bitacora.setBitaccion("INSERT carrera " + carrera.getNombreCarrera());
            insertarBitacora(bitacora);

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int actualizarCarrera(clsCarrera carrera, clsBitacora bitacora) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, carrera.getNombreCarrera());
            stmt.setString(1, carrera.getCodigoFacultad());
            stmt.setString(2, carrera.getEstatusCarrera());
            stmt.setInt(3, carrera.getCodigoCarrera());

            rows = stmt.executeUpdate();

            bitacora.setBitaccion("UPDATE carrera " + carrera.getCodigoCarrera());
            insertarBitacora(bitacora);

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int eliminarCarrera(clsCarrera carrera, clsBitacora bitacora) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);

            stmt.setInt(1, carrera.getCodigoCarrera());

            rows = stmt.executeUpdate();

            bitacora.setBitaccion("DELETE carrera " + carrera.getCodigoCarrera());
            insertarBitacora(bitacora);

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public clsCarrera obtenerCarreraPorId(int id, clsBitacora bitacora) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsCarrera carrera = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                carrera = new clsCarrera();
                carrera.setCodigoCarrera(rs.getInt("codigo_carrera"));
                carrera.setNombreCarrera(rs.getString("nombre_carrera"));
                carrera.setCodigoFacultad(rs.getString("codigo_facultad"));
                carrera.setEstatusCarrera(rs.getString("estatus_carrera"));
            }

            bitacora.setBitaccion("SELECT carrera ID " + id);
            insertarBitacora(bitacora);

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return carrera;
    }


    
    public int insertarBitacora(clsBitacora bitacora) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT_BITACORA);

            stmt.setInt(1, bitacora.getUsucodigo());
            stmt.setInt(2, bitacora.getAplcodigo());
            stmt.setString(3, bitacora.getBitfecha());
            stmt.setString(4, bitacora.getBitip());
            stmt.setString(5, bitacora.getBitequipo());
            stmt.setString(6, bitacora.getBitaccion());

            rows = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public List<clsBitacora> obtenerBitacora() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<clsBitacora> lista = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BITACORA);
            rs = stmt.executeQuery();

            while (rs.next()) {
                clsBitacora b = new clsBitacora();
                b.setBitcodigo(rs.getInt("bitcodigo"));
                b.setUsucodigo(rs.getInt("usucodigo"));
                b.setAplcodigo(rs.getInt("aplcodigo"));
                b.setBitfecha(rs.getString("bitfecha"));
                b.setBitip(rs.getString("bitip"));
                b.setBitequipo(rs.getString("bitequipo"));
                b.setBitaccion(rs.getString("bitaccion"));
                lista.add(b);
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return lista;
    }

    public int actualizarBitacora(clsBitacora bitacora) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE_BITACORA);

            stmt.setInt(1, bitacora.getUsucodigo());
            stmt.setInt(2, bitacora.getAplcodigo());
            stmt.setString(3, bitacora.getBitfecha());
            stmt.setString(4, bitacora.getBitip());
            stmt.setString(5, bitacora.getBitequipo());
            stmt.setString(6, bitacora.getBitaccion());
            stmt.setInt(7, bitacora.getBitcodigo());

            rows = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int eliminarBitacora(clsBitacora bitacora) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE_BITACORA);

            stmt.setInt(1, bitacora.getBitcodigo());

            rows = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }
}