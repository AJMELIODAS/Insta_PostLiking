import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Scanner;

public class Instagrampostliking {
      public static void main(String args[])throws Exception {
            Scanner sc=new Scanner(System.in);
            
            int numofposts=5;

            System.out.print("Enter the Insta name of the Friend: ");
            String name=sc.nextLine();
            System.out.println();

            System.out.print("Enter the Insta id: ");
            String id=sc.nextLine();
            System.out.println();

            System.out.print("Enter number of posts to like: ");
            int num=sc.nextInt();
            System.out.println();

            if(num<=0 && num!=-1 ){
                  numofposts=5;
            }
            else{
                  numofposts=num;
            }

            ChromeDriver driver = new ChromeDriver();

            driver.get("https://www.instagram.com");
            driver.manage().window().maximize();
            try{
                  Thread.sleep(1000);
                  driver.findElement(By.name("username")).sendKeys(Credentials.getInstaUser());
                  driver.findElement(By.name("password")).sendKeys(Credentials.getInstaPwd());
                  Thread.sleep(1000);

                  driver.findElement(By.xpath("//button[@type='submit']")).click();
                  Thread.sleep(3000);

                  driver.findElement(By.xpath("//button[text()='Not Now']")).click();
                  Thread.sleep(3000);

                  driver.findElement(By.xpath("//button[text()='Not Now']")).click();
                  Thread.sleep(3000);

                  driver.findElement(By.className("TqC_a")).click();
                  Thread.sleep(1000);

                  driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(name);
                  Thread.sleep(2000);

                  driver.findElement(By.xpath("//div/div[text()='"+id+"']")).click();
                  Thread.sleep(3000);

                  int posts=Integer.parseInt(driver.findElement(By.xpath("//span[@class='-nal3 ']/span[@class='g47SY ']")).getText());
                  Thread.sleep(3000);

                  driver.findElement(By.xpath("//article[@class='ySN3v']/div/div/div[1]/div[1]")).click();
                  Thread.sleep(2000);

                  List<WebElement> list=driver.findElements(By.xpath("//span[@class='fr66n']/button[@class='wpO6b  ']/div"));
                  int wantedposts=0;
                  if(numofposts>posts || num==-1){
                        wantedposts=posts;
                  }
                  else if(posts<5){
                        wantedposts=posts;
                  }
                  else{
                        wantedposts=posts-(posts-numofposts)-1;
                  }

                  for(int i=0;i<wantedposts;i++){
                  Thread.sleep(1000);
                  if(list.size()==2)// Not liked post
                  {
                  driver.findElement(By.xpath("//span[@class='fr66n']")).click();//like
                  Thread.sleep(1000);
                  if(wantedposts>1){
                  driver.findElement(By.xpath("//div[@class=' l8mY4 feth3']//span//*[name()='svg']")).click();//next
                  Thread.sleep(3000);
                  }
                  }
                  else//liked post
                  {
                        driver.findElement(By.xpath("//div[@class=' l8mY4 feth3']//span//*[name()='svg']")).click();//next
                        Thread.sleep(3000);
                  }
                  list.clear();
                  Thread.sleep(1000);
                  list=driver.findElements(By.xpath("//span[@class='fr66n']/button[@class='wpO6b  ']/div"));
                  }
                  list.clear();
                  list=driver.findElements(By.xpath("//span[@class='fr66n']/button[@class='wpO6b  ']/div"));
                  
                  if(list.size()==2)// Not liked post
                  {
                  driver.findElement(By.xpath("//span[@class='fr66n']")).click();//like
                  Thread.sleep(1000);
                  }

                  driver.findElement(By.xpath("//body/div[@role='dialog']/div[3]/button[1]")).click();
                  Thread.sleep(500);

                  driver.findElement(By.xpath("//div[@class='XrOey']/span")).click();
                  Thread.sleep(500);

                  driver.findElement(By.xpath("//div[text()='Log Out']")).click();
                  Thread.sleep(2000);
            }
            catch(Exception e){
                  System.out.println(e);
            }
            finally{
                  Thread.sleep(2000);
                  driver.close();
            }
      }
}
