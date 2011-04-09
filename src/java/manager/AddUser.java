package manager;
import pojo.Entitybase;
import java.util.HashMap;
import java.util.UUID;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pojo.Person;
import pojo.User;


public class AddUser {
    private static String eID ;

     public static String generateNewID()    {
           // String uuid = common.generateNewID()
            return UUID.randomUUID().toString();
     }
    public static String getDataCheckAdd( String userType
            , String lname , String fname, String phone, String email, String password ){
        try{
            SessionFactory sf = NewHibernateUtil.getSessionFactory();
            Session session = sf.openSession();
            Transaction tx =  session.beginTransaction();

            //check if email already pressen
            HashMap  hMap = new HashMap();
            hMap.put("userEmail",email); 
            Boolean b = ValidateDBFieldUniqueness.StringValues("Users", hMap) ;
            System.out.println("s " + b);
            if (b == true) {
              return "user exists";
            }

            //user is new, so lets add!
            Entitybase e = new Entitybase();
            eID = generateNewID();
            e.setEntityId(eID);
            session.save(e);
 
            Person p = new Person() ;
            p.setEntityId(eID);
            p.setPeopleLastName(lname);
            p.setPeopleFirstName(fname);
            p.setPeoplePhone(phone);
            p.setPeopleEmail(email);
            session.save(p);

            if (userType.equals("super")){
                User u = new User();
                u.setEntityId(eID);
                u.setUserEmail(email);
                u.setEntityId(eID);
                e.setEntityId(eID);
            }
            tx.commit();
            session.close();

        }catch(Exception e) {
        }
        return "success";
    }

    public static void main(String[] args){
        //set up user
        String s = getDataCheckAdd("0", "Fleming","Stuart","609-555-3333","ssf@gmail.com","alibaba4343");
        System.out.println(s);
    }
    
}
