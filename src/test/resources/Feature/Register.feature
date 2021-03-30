Feature: Register

Scenario Outline: Register
	Given User has accessed Home page 
	When User click on Daftar button
	And user fill email <email>
	And User click on Daftar button_2
	And click send code button
	And fill code verification
	And click verifikasi button
	And fill name <nama> and password <password>
	And click simpan button
	Then Account success Register
	
	 Examples:
	 |email|nama|password|
	 |"fedyfahron@gmail.com"|"fedytest"|"test0123"|