package pageObjects.ipms.taskmanagement;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObjects.BasePage;

public class TaskManagementPage extends BasePage{
	public TaskManagementPage(WebDriver driver){
		this.driver=driver;
	}
	//Elements
	public By addTaskManagment = By.xpath("//*[@id='sidenav']/li[2]/ul/li[2]/ul/li[1]/a");
	public By uploadTasksManagment = By.xpath("//*[@id='sidenav']/li[2]/ul/li[2]/ul/li[2]/a");
	public By viewTasksManagment = By.xpath("//*[@id='sidenav']/li[2]/ul/li[2]/ul/li[3]/a");
	
	// Methods
	public boolean isCheckAndClickAddTaskManagment(String addTaskTitle){
		WebElement addTasks= driver.findElement(addTaskManagment);
		System.out.println("Add Task "+addTasks.getText().trim());
		if(addTaskTitle.equals(addTasks.getText().trim())){
			addTasks.click();
			return true;
		}
		return false;
		
	}
	public boolean isCheckAndClickUploadTasksManagment(String uploadTasksTitle){
		WebElement uploadTasks= driver.findElement(uploadTasksManagment);
		System.out.println("Add Task "+uploadTasks.getText().trim());
		if(uploadTasksTitle.equals(uploadTasks.getText().trim())){
			uploadTasks.click();
			return true;
		}
		return false;
	}
	public boolean isCheckAndClickViewTasksManagment(String viewTasksTitle){
		WebElement uploadTasks= driver.findElement(viewTasksManagment);
		System.out.println("Add Task "+uploadTasks.getText().trim());
		if(viewTasksTitle.equals(uploadTasks.getText().trim())){
			uploadTasks.click();
			return true;
		}
		return false;
	}

}
