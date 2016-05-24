# circle-initials-view

`CircleInitialsView` allows to create circle with text shortcuted to the first letters of the first two words.
You can simply replace text with avatar.
It's similar to iOS circles from contacts.

![alt tag](https://raw.githubusercontent.com/mklimek/circle-initials-view/master/example.gif)

# Setup
**Step 1.** Add the JitPack repository to your build file.
Add it in your root build.gradle at the end of repositories:
```gradle
allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
```

**Step 2**. Add the dependency
```gradle
dependencies {
	        compile 'com.github.mklimek:circle-initials-view:$RELEASE_VERSION'
	}
```
$RELEASE_VERSION = takeTheMostRecent(https://github.com/mklimek/circle-initials-view/releases)

# Using

Simple:
```xml
<com.mklimek.circleinitialsview.CircleInitialsView
 android:layout_width="50dp"
 android:layout_height="50dp"
 custom:text="Marek Kowalski" />
```

Custom colors:
```xml
<com.mklimek.circleinitialsview.CircleInitialsView
 android:layout_width="50dp"
 android:layout_height="50dp"
 custom:backgroundColor="#771175"
 custom:textColor="#48c192"
 custom:text="Adam Smith" />
```

Avatar:
```xml
<com.mklimek.circleinitialsview.CircleInitialsView
 android:layout_width="50dp"
 android:layout_height="50dp"
 custom:avatar="@drawable/avatar" />
```

All available attributes are listed [here](https://github.com/mklimek/circle-initials-view/blob/master/circleinitialsview/src/main/res/values/attrs.xml) .

You can also add it programmatically:
```java
CircleInitialsView circleView = new CircleInitialsView(this, Color.LTGRAY, 15, Color.DKGRAY, "Kasia Kowalska");

LinearLayout ll = (LinearLayout) findViewById(R.id.container);
ll.addView(circleView);

LinearLayout.LayoutParams p = (LinearLayout.LayoutParams) circleView.getLayoutParams();
p.width = p.height = 50;
circleView.setLayoutParams(p);
```

and call `setOnClickListener` and do whatever you need for instance change properties by setters:
```java
circleView.setOnClickListener(new View.OnClickListener() {
    private boolean avatar = false;
    @Override
    public void onClick(View v) {
        CircleInitialsView cw = (CircleInitialsView) v;
        if(avatar){
            cw.setText("Mietek Szcześniak");
        } else{
            cw.setAvatar(R.drawable.avatar);
        }
        avatar = !avatar;
    }
});
```
