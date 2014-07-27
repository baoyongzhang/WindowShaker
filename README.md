WindowShaker
============

android window shake

# Demo


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
