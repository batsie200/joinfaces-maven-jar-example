/*
 * Copyright 2016-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.joinfaces.example.view;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomInputPage {

	private final WebDriver webDriver;

	@FindBy(name = "customInput:inputfield")
	private WebElement inputByName;

	@FindBy(name = "customInput:submit")
	private WebElement buttonByName;

	public CustomInputPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public void submit(String message) {
		inputByName.sendKeys(message);

		buttonByName.click();

		By paragraphBy = By.xpath("//p");
		String expectedValue = "You entered: " + message;

		new WebDriverWait(webDriver, 5000).until(ExpectedConditions.textToBe(paragraphBy, expectedValue));
	}

}