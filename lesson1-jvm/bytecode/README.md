### 编译步骤
#### 1.进入类文件所在的目录，这里为 C:\code\JavaCourse\lesson1-jvm\bytecode\src\main\java\com\geekbang
#### 2.使用javac命令编译文件 javac .\Main.java，可以得到编译文件
#### 3.使用 javap -c .\Main.class 命令查看字节码文件
```
Compiled from "Main.java"
public class com.geekbang.Main {
  public com.geekbang.Main();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: new           #2                  // class com/geekbang/Main
       3: dup
       4: invokespecial #3                  // Method "<init>":()V
       7: astore_1
       8: iconst_1
       9: istore_2
      10: iconst_2
      11: istore_3
      12: aload_1
      13: iload_2
      14: iload_3
      15: invokevirtual #4                  // Method add:(II)I
      18: pop
      19: return

  public int add(int, int);
    Code:
       0: iconst_0
       1: istore_3
       2: iload_1
       3: ifeq          14
       6: iload_2
       7: ifeq          14
      10: iload_1
      11: iload_2
      12: iadd
      13: istore_3
      14: iload_1
      15: ifne          24
      18: iload_2
      19: ifeq          24
      22: iload_2
      23: istore_3
      24: iload_1
      25: ifeq          34
      28: iload_2
      29: ifne          34
      32: iload_1
      33: istore_3
      34: iload_3
      35: ireturn
}
```
#### 4.使用javap -c -verbose .\Main.class 命令查看字节码文件，可以看到请求参数、常量池的信息等
```
Classfile /C:/code/JavaCourse/lesson1-jvm/bytecode/src/main/java/com/geekbang/Main.class
  Last modified 2021-11-7; size 462 bytes
  MD5 checksum b805c69ba2b3d6bfd20daa2102db8563
  Compiled from "Main.java"
public class com.geekbang.Main
  minor version: 0
  major version: 52
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #5.#17         // java/lang/Object."<init>":()V
   #2 = Class              #18            // com/geekbang/Main
   #3 = Methodref          #2.#17         // com/geekbang/Main."<init>":()V
   #4 = Methodref          #2.#19         // com/geekbang/Main.add:(II)I
   #5 = Class              #20            // java/lang/Object
   #6 = Utf8               <init>
   #7 = Utf8               ()V
   #8 = Utf8               Code
   #9 = Utf8               LineNumberTable
  #10 = Utf8               main
  #11 = Utf8               ([Ljava/lang/String;)V
  #12 = Utf8               add
  #13 = Utf8               (II)I
  #14 = Utf8               StackMapTable
  #15 = Utf8               SourceFile
  #16 = Utf8               Main.java
  #17 = NameAndType        #6:#7          // "<init>":()V
  #18 = Utf8               com/geekbang/Main
  #19 = NameAndType        #12:#13        // add:(II)I
  #20 = Utf8               java/lang/Object
{
  public com.geekbang.Main();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 3: 0

  public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=3, locals=4, args_size=1
         0: new           #2                  // class com/geekbang/Main
         3: dup
         4: invokespecial #3                  // Method "<init>":()V
         7: astore_1
         8: iconst_1
         9: istore_2
        10: iconst_2
        11: istore_3
        12: aload_1
        13: iload_2
        14: iload_3
        15: invokevirtual #4                  // Method add:(II)I
        18: pop
        19: return
      LineNumberTable:
        line 5: 0
        line 6: 8
        line 7: 10
        line 8: 12
        line 9: 19

  public int add(int, int);
    descriptor: (II)I
    flags: ACC_PUBLIC
    Code:
      stack=2, locals=4, args_size=3
         0: iconst_0
         1: istore_3
         2: iload_1
         3: ifeq          14
         6: iload_2
         7: ifeq          14
        10: iload_1
        11: iload_2
        12: iadd
        13: istore_3
        14: iload_1
        15: ifne          24
        18: iload_2
        19: ifeq          24
        22: iload_2
        23: istore_3
        24: iload_1
        25: ifeq          34
        28: iload_2
        29: ifne          34
        32: iload_1
        33: istore_3
        34: iload_3
        35: ireturn
      LineNumberTable:
        line 12: 0
        line 13: 2
        line 14: 10
        line 16: 14
        line 17: 22
        line 19: 24
        line 20: 32
        line 22: 34
      StackMapTable: number_of_entries = 3
        frame_type = 252 /* append */
          offset_delta = 14
          locals = [ int ]
        frame_type = 9 /* same */
        frame_type = 9 /* same */
}
SourceFile: "Main.java"
```
