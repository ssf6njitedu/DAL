package manager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ValidateDBFieldUniqueness {

public static Boolean StringValues (String Table,HashMap mapList) {
// Boolean b =    ValidateDBFieldUniqueness.StringValues("table",Hmap) ;
   Boolean myReturn =  false  ;
   int i = 0;
   String hql = "from " + Table  ;
   if( mapList.size() > 0) hql = hql + " where " ;
   Set entries = mapList.entrySet();
   Iterator it = entries.iterator();
   while (it.hasNext()) {
      Map.Entry entry = (Map.Entry) it.next();
      System.out.println(entry.getKey() + " " + entry.getValue());
        if( i!=0)  hql = hql + " and "  ;
         hql = hql + " " + entry.getKey()+ "=" +  "'" + entry.getValue() +  "'";
         i++;
    }
        try{
            SessionFactory sf = NewHibernateUtil.getSessionFactory();
            Session session = sf.openSession();
            System.out.println ( "select * " + hql + ";" ) ;

            Query query = session.createQuery(hql);
            List users = query.list();
            if (users.isEmpty()) {
                myReturn =  false  ;
            } else {
                myReturn =  true  ;
            }
            System.out.println ( "users list size: " + users.size()) ;
            session.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
   return  myReturn  ;

}
    public static void main(String[] args){

        HashMap  hMap = new HashMap();
        hMap.put("UserID","123456");
        hMap.put("UserEmail","math@gmail.com");
        hMap.put("UserPasswordHash","7890");

        Boolean s = ValidateDBFieldUniqueness.StringValues("User", hMap) ;
        System.out.println("s " + s);
    }
}
