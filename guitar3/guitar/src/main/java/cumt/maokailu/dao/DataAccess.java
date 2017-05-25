package cumt.maokailu.dao;

public class DataAccess {
	private static String db = "Sqlite";
    public static GuitarDao CreateGuitarDao()
    {
        GuitarDao result = null;
        switch (db)
        {
        //根据变量名选择数据库
            case "Sqlite":
                result = new cumt.maokailu.sqliteDao.GuitarDaoImpl();
                break;
            case "Mysql":
                result = new cumt.maokailu.mysqlDao.GuitarDaoImpl();
                break;
        }
        return result;
    }

}
