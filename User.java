package HealthyLivingPlanner;
public class User
{
    private String name;
    private String password;
    private double age;
    private char gender;
    private double height;
    private double weight;

    public User()
    {
        double randomNumber = Math.random() * 10;
        if (randomNumber <= 5.0) {
            name = "John Doe";
            password = "123John";
            gender = 'M';
        }
        else {
            name = "Jane Doe";
            password = "123Jane";
            gender = 'F';
        }
        age = 42;
        height = 175;
        weight = 190;
    }
    
    public User(String n, String p, double a, char g, double h, double w)
    {
        name = n;
        password = p;
        age = a;
        gender = g;
        height = h;
        weight = w;
    }

    public User(String n)
    {
        name = n;
        password = "123";
        age = 16;
        gender = 'f';
        height = 150;
        weight = 280;
    }

    public void setName(String n)
    {
        name = n;
    }

    public String getName()
    {
        return name;
    }
    
    public void setPassword(String p)
    {
        password = p;
    }

    public String getPassword()
    {
        return password;
    }

    public void setAge(double x)
    {
        age = x;
    }

    public double getAge()
    {
        return age;
    }

    public void setGender(char ch) {
        gender = ch;
    }
   
    public char getGender(){
        return gender;
    }
    
    public void setHeight(double x)
    {
        height = x;
    }

    public double getHeight()
    {
        return height;
    }

    public void setWeight(double we)
    {
        weight = we;
    }

    public double getWeight()
    {
        return weight;
    }

    @Override
    public String toString()
    {
      String objectInfo = "";
      objectInfo = name + ",";
      objectInfo = objectInfo + password + ",";
      objectInfo = objectInfo + age + ",";
      objectInfo = objectInfo + gender + ",";
      objectInfo = objectInfo + height + ",";
      objectInfo = objectInfo + weight;
      return objectInfo;
    }
}