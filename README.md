# circle-initials-view

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
