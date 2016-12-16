package com.proiect.echipa478a.proiectandroid.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.proiect.echipa478a.proiectandroid.R;
import com.proiect.echipa478a.proiectandroid.custom.datapojo.User;
import com.proiect.echipa478a.proiectandroid.custom.persistency.custom.UserDatabaseManager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {
    public static final String NO_USER_LOGGED = "com.proiect.echipa478a.proiectandroid.NO_USER_LOGGED";
    public static final String REGISTER_OTHER_USER = "com.proiect.echipa478a.proiectandroid.REGISTER_OTHER_USER";
    public static final String SIGN_IN_AS_GUEST = "com.proiect.echipa478a.proiectandroid.SIGN_IN_AS_GUEST";
    public static final String LOGIN_SUCCESSFUL = "com.proiect.echipa478a.proiectandroid.LOGIN_SUCCESSFUL";

    private Button loginBtn;
    private Button guestSignBtn;
    private TextView userName;
    private TextView userEmail;

    private UserDatabaseManager userDatabaseManager;

    private String loginIntentAction = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        Intent intent = getIntent();
        loginIntentAction = intent.getAction();

        guestSignBtn = (Button) findViewById(R.id.guestSignInBtn);
        userName = (TextView) findViewById(R.id.userNameTV);
        userEmail = (TextView) findViewById(R.id.emailTV);
        loginBtn = (Button) findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(userName.getText().toString().trim().isEmpty()) {
                    userName.setError("Please enter a valid username");
                    return;
                } else if(userName.getText().toString().length() < 3) {
                    userName.setError("Username must be at least 3 charachters long.");
                    return;
                } else if(userEmail.getText().toString().trim().isEmpty() || !isEmailValid(userEmail.getText().toString())) {
                    userEmail.setError("This must be a valid email address.");
                    return;
                }

                User user = new User(userName.getText().toString(), userEmail.getText().toString());
                if(loginIntentAction.equals(REGISTER_OTHER_USER)) {
                    User.setUserLogged(user, userDatabaseManager, REGISTER_OTHER_USER);
                    User.isGuestUser(false);
                } else if(loginIntentAction.equals(NO_USER_LOGGED)) {
                    User.setUserLogged(user, userDatabaseManager, NO_USER_LOGGED);
                    User.isGuestUser(false);
                }


                Intent returnIntent = new Intent();
                returnIntent.setAction(LOGIN_SUCCESSFUL);
                returnIntent.putExtra("UserName", user.getName());
                setResult(MainActivity.RESULT_OK,returnIntent);
                finish();
            }
        });

        guestSignBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User.setUserLogged(null, userDatabaseManager, SIGN_IN_AS_GUEST);
                User.isGuestUser(true);

                Intent returnIntent = new Intent();
                returnIntent.setAction(SIGN_IN_AS_GUEST);
                setResult(MainActivity.RESULT_OK,returnIntent);
                finish();
            }
        });

    }

    @Override
    protected void onStart() {
        userDatabaseManager = new UserDatabaseManager(this);
        userDatabaseManager.open();
        super.onStart();
    }

    @Override
    protected void onStop() {
        if(userDatabaseManager != null){
            userDatabaseManager.close();
        }
        super.onStop();
    }

    /**
     * method is used for checking valid email id format.
     *
     * @param email
     * @return boolean true for valid false for invalid
     */
    public static boolean isEmailValid(String email) {
        boolean isValid = false;

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }

}
