package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Driver;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.xml.transform.Result;

/**
 * @desc A singleton database access class for MySQL
 */
public final class DbConnect {
    public Connection conn;
    private Statement statement;
    public static DbConnect db;

    private DbConnect() {
        String url= "jdbc:mysql://130.226.142.46:3306/";
        //String url = "jdbc:mysql://mysql.itu.dk:3306/";
        String dbName = "SelfService2000";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "mcjorgel";
        String password = "cookie";
        try {
            Class.forName(driver).newInstance();
            this.conn = (Connection) DriverManager.getConnection(url + dbName, userName, password);
        } catch (Exception sqle) {
            sqle.printStackTrace();
        }
    }

    /**
     * @return MysqlConnect Database connection object
     */
    public static synchronized DbConnect getDbCon() {
        if (db == null) {
            db = new DbConnect();
        }
        return db;
    }

    //Data fetching methods
    public void testConn() {
        try
        {
            statement = db.conn.createStatement();
            int result = statement.executeUpdate("insert into users values" +
                    " (null,'something@something.com', 'mr test', 'abdc', 'pass', 1, 'apisdf',null);");
            System.out.println(result);
        }
        catch (SQLException ex){
            System.out.println(ex);
        }
    }

    public static void main(String[] args){
        DbConnect db = DbConnect.getDbCon();
        db.testConn();
    }


    public ResultSet query(String query) throws SQLException{
        statement = db.conn.createStatement();
        ResultSet res = statement.executeQuery(query);
        return res;
    }

    public int insert(String insertQuery) throws SQLException {
        statement = db.conn.createStatement();
        int result = statement.executeUpdate(insertQuery);
        return result; //nr of rows affected
    }

    public String sanitize(String string){
        //TODO: Figure out sanitizing
        return string;
    }

    public String hashPassword(String password){
//        TODO: Figure out hashing
        return password;
    }

    
    public User authenticateUser (String email, String password){
        String query = "Select * from users where email='" +email +"';";

        //TODO: include hashing
        String hashedPassword = hashPassword(password);

        try {
            ResultSet resultSet = query(query);

            while (resultSet.next()){
                String dbPassword = resultSet.getString("password");
                if(!hashedPassword.equals(dbPassword)) return null;

                int id = Integer.parseInt(resultSet.getString("id"));
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String picture = resultSet.getString("picture");
                int type = Integer.parseInt(resultSet.getString("type"));
                int business_id = Integer.parseInt(resultSet.getString("business_id"));

                return new User(id, email, name, surname, dbPassword, type, picture, business_id);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    //    TODO: maybe it's ok
    public User createUser(String name, String surname, String email, String password, int type, int business_id){

//        check if email is taken
        List<User> existingUser = getUsersByEmail(email);
        if (!existingUser.isEmpty()) return null;

        String query = "Insert into users (email, name, surname, password, type, picture, business_id) " +
                "values('" + email + "','" + name + "','" + surname + "', '" +
                hashPassword(password) + "', " + type + ",'default.jpg', " + business_id +")";

        try {
            int rowsAffected = insert(query);

            if (rowsAffected==1){
                /*
                Erida says:
                There is a smarter way of getting the id of the new user (hint: Statement.RETURN_GENERATED_KEYS)
                but it requires a new insert method and it might turn out to not be supported
                so I'm choosing the easy(lazy) way of doing it.

                If sb improves this code I won't mind :)
                 */

                List<User> userlist = getUsersByEmail(email);

//                TODO: idk if this is okay?
                if(userlist.size()==1) return userlist.get(0);

                //else you either did not insert (?????)
                // or you have more than 1 user with the same email (?????)
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    public List<User> getUsersByEmail(String email){
        List<User> users = new ArrayList<>();

        String newEmail = sanitize(email);
        String query= "Select * from users where email='" + newEmail + "';";

        try {
            ResultSet result = query(query);

            while (result.next()){
                int id = Integer.parseInt(result.getString("id"));
                email = result.getString("email");
                String name = result.getString("name");
                String surname = result.getString("surname");
                String password = result.getString("password");
                int type = Integer.parseInt(result.getString("type"));
                String picture = result.getString("picture");
                int business_id = Integer.parseInt(result.getString("id"));

                users.add(new User(id, email, name, surname, password,
                        type, picture, business_id));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public List<Business> getBusinesses(){
        List<Business> businesses = new ArrayList<>();

        String query= "Select * from businesses;";

        try {
            ResultSet result = query(query);

            while (result.next()){
                int id = Integer.parseInt(result.getString("id"));
                String name = result.getString("name");
                String address = result.getString("address");
                String city = result.getString("city");
                String country = result.getString("country");
                String cvr = result.getString("cvr");
                String bankaccount = result.getString("bankaccount");
                String mobilepay = result.getString("mobilepay");
                String phonenumber = result.getString("phonenumber");
                String logo = result.getString("logo");

                businesses.add(new Business(id, name, address, city, country,
                        cvr, bankaccount, mobilepay, phonenumber, logo));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return businesses;
    }

    public Map<String, List<Item>> getMenuByBusinessId(int business_id){
        //maps category to items in that category
        Map<String, List<Item>> menu = new HashMap<>();

        String query= "Select items.*, categories.name as category_name from items, categories where" +
                " items.category_id = category.id and items.business_id=" + business_id + ";";

        try {
            ResultSet result = query(query);

            while (result.next()){
                int id = Integer.parseInt(result.getString("id"));
                int bus_id = Integer.parseInt(result.getString("business_id"));
                String name = result.getString("name");
                int quantity = Integer.parseInt(result.getString("quantity"));
                double price = Double.parseDouble(result.getString("price"));
                String description = result.getString("description");
                String picture = result.getString("picture");
                int category_id = Integer.parseInt(result.getString("category_id"));
                String category_name = result.getString("category_name");

                Item item = new Item(id, business_id, name, quantity, price, description, picture, category_id);

                List<Item> items = new ArrayList<>();

                if(menu.containsKey(category_name)) {
                    items = menu.get(category_name);
                }

                items.add(item);
                menu.put(category_name, items);

            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return menu;
    }

    public Map<Order, List<OrderItem>> getOrdersByCustomerId(int customer_id){
        Map<Order, List<OrderItem>> orders = new HashMap<>();

        String query= "Select * from orders where user_id=" + customer_id + ";";

        try {
            ResultSet result = query(query);

            while (result.next()){
                int id = Integer.parseInt(result.getString("id"));
                Timestamp time = Timestamp.valueOf(result.getString("time"));
                int user_id = Integer.parseInt(result.getString("user_id"));
                int business_id = Integer.parseInt(result.getString("business_id"));
                double total = Double.parseDouble(result.getString("total"));
                int state = Integer.parseInt(result.getString("state"));

                Order order = new Order(id, time, user_id, business_id, total,state);

                query = "Select orderitems.*,items.* from orderitems, items" +
                        " where orderitems.order_id= " + id + "' and " +
                        "orderitems.item_id = items.id";

                ResultSet orderItemsResult = query(query);
                List<OrderItem> orderItems = new ArrayList<>();

                while (orderItemsResult.next()){
                    int order_id = Integer.parseInt(result.getString("order_id"));
                    int item_id = Integer.parseInt(result.getString("item_id"));
                    int quantity = Integer.parseInt(result.getString("quantity"));
//                    We already have the business_id
//                    int business_id = Integer.parseInt(result.getString("business_id"));
                    String name = result.getString("name");
                    int stock_left = Integer.parseInt(result.getString("stock_left"));
                    double price = Integer.parseInt(result.getString("price"));
                    String description = result.getString("description");
                    String picture = result.getString("picture");
                    int category_id = Integer.parseInt(result.getString("category_id"));

                    Item item = new Item(item_id, business_id, name, stock_left, price, description, picture, category_id);
                    OrderItem orderItem =  new OrderItem(order_id, item_id, item, quantity);

                    orderItems.add(orderItem);
                }

                orders.put(order, orderItems);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }

    public boolean updateOrderState(int order_id, int loggedIn_id, int loggedIn_business_id, int newState){

        String query = "Select * from orders where id=" + order_id + ";";
        try {
            ResultSet resultSet = query(query);

            while (resultSet.next()){
                int id = Integer.parseInt(resultSet.getString("id"));
                Timestamp time = Timestamp.valueOf(resultSet.getString("time"));
                int user_id = Integer.parseInt(resultSet.getString("user_id"));
                int bus_id = Integer.parseInt(resultSet.getString("bus_id"));
                double total = Double.parseDouble(resultSet.getString("total"));
                int state = Integer.parseInt(resultSet.getString("state"));

                //An order can be cancelled by the customer who made it
                // only if it still pending (state 1)
                if(user_id == loggedIn_id && state == 1 && newState == 4){
                    query = "Update orders set state=4 where id="+ order_id +";";

                    int rowsAffected= insert(query);
                    if(rowsAffected==1) return true;
                }

                //The order status can be changed by staff only if they're
                // working in the business the order was made to
                else if(bus_id == loggedIn_business_id){
                    //TODO: Discuss if staff can cancel order at any state

                    //Transition from pending to processing
                    if(state == 1 && newState == 2){
                        query = "Update orders set state=2 where id="+ order_id +";";

                        int rowsAffected= insert(query);
                        if(rowsAffected==1) return true;
                    }

                    //Transition from pending to cancelled
                    else if(state == 1 && newState == 4){
                        query = "Update orders set state=4 where id="+ order_id +";";

                        int rowsAffected= insert(query);
                        if(rowsAffected==1) return true;
                    }

                    //Transition from processing to ready
                    else if(state == 2 && newState == 3){
                        query = "Update orders set state=3 where id="+ order_id +";";

                        int rowsAffected= insert(query);
                        if(rowsAffected==1) return true;
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public  Map<Order, List<OrderItem>> getOrdersByBusinessId(int business_id) {
        Map<Order, List<OrderItem>> orders = new HashMap<>();

        String query = "Select * from orders where business_id=" + business_id + ";";

        try {
            ResultSet result = query(query);

            while (result.next()) {
                int id = Integer.parseInt(result.getString("id"));
                Timestamp time = Timestamp.valueOf(result.getString("time"));
                int user_id = Integer.parseInt(result.getString("user_id"));
//                Given as a parameter
//                int business_id = Integer.parseInt(result.getString("business_id"));
                double total = Double.parseDouble(result.getString("total"));
                int state = Integer.parseInt(result.getString("state"));

                Order order = new Order(id, time, user_id, business_id, total, state);

                query = "Select orderitems.*,items.* from orderitems, items" +
                        " where orderitems.order_id= " + id + "' and " +
                        "orderitems.item_id = items.id";

                ResultSet orderItemsResult = query(query);
                List<OrderItem> orderItems = new ArrayList<>();

                while (orderItemsResult.next()) {
                    int order_id = Integer.parseInt(result.getString("order_id"));
                    int item_id = Integer.parseInt(result.getString("item_id"));
                    int quantity = Integer.parseInt(result.getString("quantity"));
//                    We already have the business_id
//                    int business_id = Integer.parseInt(result.getString("business_id"));
                    String name = result.getString("name");
                    int stock_left = Integer.parseInt(result.getString("stock_left"));
                    double price = Integer.parseInt(result.getString("price"));
                    String description = result.getString("description");
                    String picture = result.getString("picture");
                    int category_id = Integer.parseInt(result.getString("category_id"));

                    Item item = new Item(item_id, business_id, name, stock_left, price, description, picture, category_id);
                    OrderItem orderItem = new OrderItem(order_id, item_id, item, quantity);

                    orderItems.add(orderItem);
                }

                orders.put(order, orderItems);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }

    public boolean createOrder(int user_id, int business_id, Map<Integer, Integer> item_idToQuantity){
        double total = 0;
        String query;
        int id;

        //query price of each item to calculate total
        for (Map.Entry<Integer, Integer> entry : item_idToQuantity.entrySet()) {
            int item_id = entry.getKey();
            int quantity = entry.getValue();

            query = "Select * from items where id=" + item_id + ";";

            try {
                ResultSet result = query(query);

                while (result.next()) {
                    int stock_left = Integer.parseInt(result.getString("stock_left"));

                    //if not enough items in stock order fails
                    if(stock_left<quantity) return false;

                    double price = Double.parseDouble(result.getString("price"));

                    total += price * quantity;
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
                //if an item fails to be retrieved then the order cannot be completed
                return false;
            }

        }

        Date date = new Date();
        Timestamp time = new Timestamp(date.getTime());

        query= "Insert into orders(time, user_id, business_id, total, state)" +
                "values(" + time + ", " + user_id + ", " + business_id +", " +
                total + ", 1);";

        try {
            int rowsAffected = insert(query);

            //if order was inserted you have to insert order items
            if(rowsAffected == 1) {

                //get order_id
                query = "Select * from orders where time=" + time + " and user_id ="
                        + user_id + " and business_id=" + business_id + ";";

                try {
                    ResultSet result = query(query);

//                    while (result.next()) {
                        id = Integer.parseInt(result.getString("id"));
//                    }

                    for (Map.Entry<Integer, Integer> entry : item_idToQuantity.entrySet()) {
                        int item_id = entry.getKey();
                        int quantity = entry.getValue();

                        query = "Insert into orderitems(order_id, item_id, quantity) " +
                                "values (" + id + ", " + item_id + ", " + quantity + ";";

                        rowsAffected = insert(query);

                        //I'm ignoring the case when the insertion fails because then we would
                        //have to undo so many insertions and we don't have enough time for that
                    }

                    return true;
                }
                catch (SQLException e) {
                    e.printStackTrace();
                    //if an item fails to be retrieved then the order cannot be completed
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return false;
    }

}
