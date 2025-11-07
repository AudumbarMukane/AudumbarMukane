package com.test;

import com.microsoft.playwright.Locator;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class GoogleSearch {
	
    @Test 
	public void Launching_Browser () {
		
	    // Create a Playwright instance
        try (Playwright playwright = Playwright.create()) {
            // Launch a Chromium browser (set headless=false to see the browser)
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            
            // Create a new browser context and page
            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            // Navigate to Google
            page.navigate("https://www.flipkart.com/");

            page.waitForLoadState();
            // Optional: Print the page title
            System.out.println("Page title: " + page.title());

            // Wait for a few seconds so you can see the page
            //page.waitForTimeout(5000);
         
         // Locate the element
            Locator element = page.locator("//span[@role='button']");

            

            // Close everything
            browser.close();
        }
    }

	}

