WindowShaker
============

android window shake

# Demo
<p>
   <img src="https://raw.githubusercontent.com/baoyongzhang/WindowShaker/master/demo.gif" width="320" alt="demo"/>
</p>

# Usage

## Activity or Fragment
```java
WindowShaker.shake(this);
```
## Option
```java
Option option = new Option.Builder(this).setDuration(2000).setOffsetX(20)
				.setOffsetY(5).setRepeatCount(15).setVibrate(false).build();
WindowShaker.shake(this, option);
```
