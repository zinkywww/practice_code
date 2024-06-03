### 1. 抽象类和接口

* **目的和使用场景**：

  - **抽象类**用于在多个相关类之间共享代码，同时定义必须实现的行为。适合用来表示具有共性的一组类。
  - **接口**用于定义不相关的类之间的一组共同行为，强调实现特定行为而不关注这些类之间的关系。

  **方法实现**：

  - **抽象类**可以有已实现的方法和抽象方法。
  - **接口**中的方法都是抽象的，没有实现。java 1.8中可以定义default方法体，而抽象类可以有定义与实现，方法可在抽象类中实现。

  **成员变量**：

  - **抽象类**可以有实例变量和常量。
  - **接口**只能有静态常量，不能有实例变量。

  **构造函数**：

  - **抽象类**可以有构造函数。
  - **接口**没有构造函数。

  **继承和实现**：

  - **抽象类**通过`extends`关键字继承，一个类只能继承一个抽象类。
  - **接口**通过`implements`关键字实现，一个类可以实现多个接口。

### 2. 值传递和引用传递

* **值传递**：在值传递中，方法接收的是参数值的一个副本。方法内对参数的修改不会影响到原始变量。Java 中所有的参数传递都是值传递。对于基本类型，传递的是值的副本。对于引用类型，传递的是引用的副本，但由于引用指向同一个对象，所以可以通过引用修改对象的状态。
* **引用传递**：在引用传递中，方法接收的是参数的引用（即地址）。方法内对参数的修改将影响到原始变量，因为方法操作的是同一个对象。在 Java 中不存在真正意义上的引用传递，即不会传递变量本身的内存地址，但可以通过传递对象引用实现类似效果。

### 3. final，finally，finalize

1. final
   * java中的关键字，修饰符。
     A).如果一个类被声明为final，就意味着它不能再派生出新的子类，不能作为父类被继承。因此，一个类不能同时被声明为abstract抽象类的和final的类。
     B).如果将变量或者方法声明为final，可以保证它们在使用中不被改变.
     　　1)被声明为final的变量必须在声明时给定初值，而在以后的引用中只能读取，不可修改。
     　　2)被声明final的方法只能使用，不能重载。
2. finally
   * finally只能用在try/catch语句中并且附带着一个语句块，表示这段语句最终总是被执行。
3. finalize
   * `finalize` 是 `java.lang.Object` 类中的一个方法。当垃圾回收器确定不再有对对象的引用时，调用此方法。它通常用于在对象被垃圾回收之前进行清理操作。

### 4. 重写和重载

1. 重写
   * 子类继承了父类原有的方法，但有时子类并不想原封不动的继承父类中的某个方法，所以**在方法名，参数列表，返回类型(除过子类中方法的返回值是父类中方法返回值的子类时)都相同的情况下，** 对方法体进行修改或重写，这就是重写。但要注意**子类函数的访问修饰权限不能少于父类的。**
2. 重载
   * 在一个类中，同名的方法如果有不同的参数列表（**参数类型不同、参数个数不同甚至是参数顺序不同**）则视为重载。同时，重载对返回类型没有要求，可以相同也可以不同，但**不能通过返回类型是否相同来判断重载**。

### 5. 封装、继承、多态

1. 封装
   * 封装是指将对象的属性（字段）和行为（方法）结合起来，隐藏对象的内部实现细节，只暴露必要的接口给外部使用。这一原则使得对象的数据和行为更加安全和模块化。
   * 实现：
     * 私有化字段：内部对象私有化。
     * 提供公共方法：通过公共方法来访问和修改私有化字段。
2. 继承
   * 继承是面向对象编程中的一个机制，它允许一个类（子类）继承另一个类（父类）的属性和方法，从而实现代码的重用和层次化结构。子类可以扩展或修改父类的行为。
   * 实现：
     * 使用extend。
     * 使用super调用父类方法。
3. 多态
   * 多态是指一个方法可以有不同的实现方式。它允许一个接口或方法在不同的上下文中表现出不同的行为。多态性通过方法重载（编译时多态）和方法重写（运行时多态）实现。
   * 方法重载：在同一个类中，方法名称相同但参数列表不同（参数类型、个数、顺序）的多个方法。
   * 方法重写：在子类中重新定义父类中的方法，方法签名相同，返回类型相同或是子类型。
   * 多态的体现：父类引用指向子类对象，实现方法调用的动态绑定。

### 6. String

1. 字符串常量池
   * Java 中的常量池（或字符串池）是一个特殊的内存区域，用于存储字符串字面量和通过 `intern()` 方法存储的字符串的引用。它的目的是避免重复创建相同内容的字符串，从而节省内存。Java 中⽤双引号括起来的字符串，例如："abc"、"def"，都是直接存储在“⽅法区”的“字符串常量池”当中的。
2. string为什么私有？
   * 存储字符串的数组被final修饰且为私有，string没有提供修改的方法。string被final修饰不能被继承，避免子类破坏string不可变。
3. string，stringbuilder，stringbuffer
   1. String（不可变，线程安全）
      *  String 是不可变的，⼀旦创建了字符串对象，其值就不能被修改。对字符串的任何修改都会创建⼀个新的 字符串对象。 String 是线程安全的，因为它的不可变性使得多个线程可以同时访问同⼀个字符串对象⽽不会发⽣竞争条 件。 由于不可变性，对字符串的修改操作（例如连接、截取）可能会导致创建新的字符串对象，影响性能。
   2. StringBuffer（可变、线程安全） 
      * StringBuffer 是可变的，它允许在同⼀对象上执⾏修改操作，⽽不创建新的对象。 StringBuffer 是线程安全的，它的⽅法是同步的，可以安全地在多个线程中使⽤。 由于可变性， StringBuffer 适⽤于在多线程环境中进⾏字符串操作，但在单线程环境中，相⽐ StringBuilder ，可能会有⼀些性能开销。 
   3. StringBuilder(可变、⾮线程安全) 
      * StringBuilder 也是可变的，类似于 StringBuffer StringBuilder 是⾮线程安全的，它的⽅法没有同步，因此在多线程环境中使⽤时需要注意同步问题。 由于可变性， StringBuilder 适⽤于在单线程环境中进⾏字符串操作，且通常⽐ StringBuffer 性能更 好，因为它不需要同步。

### 7. 包装类

1. 包装类的基本类型区别
   * **用途**：除了定义一些常量和局部变量之外，我们在其他地方比如方法参数、对象属性中很少会使用基本类型来定义变量。并且，包装类型可用于泛型，而基本类型不可以。包装类用于将基本类型转为对象。
   * **存储方式**：基本数据类型的局部变量存放在 Java 虚拟机栈中的局部变量表中，基本数据类型的成员变量（未被 `static` 修饰 ）存放在 Java 虚拟机的堆中。包装类型属于对象类型，我们知道几乎所有对象实例都存在于堆中。
   * **占用空间**：相比于包装类型（对象类型）， 基本数据类型占用的空间往往非常小。
   * **默认值**：成员变量包装类型不赋值就是 `null` ，而基本类型有默认值且不是 `null`。
   * **比较方式**：对于基本数据类型来说，`==` 比较的是值。对于包装数据类型来说，`==` 比较的是对象的内存地址。所有整型包装类对象之间值的比较，全部使用 `equals()` 方法。
2. 包装类缓存
3. 自动装箱与拆箱
   * **装箱**：将基本类型用它们对应的引用类型包装起来；`Integer i = 10` 等价于 `Integer i = Integer.valueOf(10)`
   * **拆箱**：将包装类型转换为基本数据类型；`int n = i` 等价于 `int n = i.intValue()`

### 8. static关键字

* 静态变量：静态变量也就是被 `static` 关键字修饰的变量。它可以被类的所有实例共享，无论一个类创建了多少个对象，它们都共享同一份静态变量。也就是说，静态变量只会被分配一次内存，即使创建多个对象，这样可以节省内存。
* 静态方法：静态方法是属于类的，而不是属于某个实例的。可以通过类名直接调用静态方法。静态方法不能访问实例变量和实例方法，因为它们没有特定的实例上下文。静态方法常用于工具类或辅助方法（如 `Math` 类中的方法）。
* 静态代码块：在类加载时加载，静态代码块用于初始化静态变量，且在类加载时执行一次

### 9. 成员变量和局部变量

**定义位置**：

- **成员变量**：定义在类中，但在方法、构造函数或代码块之外。
- **局部变量**：定义在方法、构造函数或代码块中。

**作用域**：

- **成员变量**：作用域是整个类。
- **局部变量**：作用域是定义它们的方法、构造函数或代码块。

**生命周期**：

- **成员变量**：生命周期与对象的生命周期一致。
- **局部变量**：生命周期从声明开始，到所在方法或代码块结束为止。

**默认值**：

- **成员变量**：有默认值，Java 会自动初始化。
- **局部变量**：没有默认值，必须显式初始化。

**内存位置**：

- **成员变量**：存储在堆内存中（因为它们是对象的一部分）。
- **局部变量**：存储在栈内存中。

**访问修饰符**：

- **成员变量**：可以使用访问修饰符（如 `private`、`public`、`protected`）来控制访问级别。
- **局部变量**：不能使用访问修饰符，它们的访问级别仅限于所在的代码块。

### 10. 错误与异常

1. error与exception区别？
   * error和exception都继承自throwable类。
   * error表示java运行时系统的内部错误和资源耗尽问题，不应该抛出这样的错误，出现了这样的错误，应该通知用户，并尽可能的妥善的终止程序，程序无法处理这样的错误，如 Java 虚拟机运行错误（`Virtual MachineError`）、内存溢出(`OutOfMemoryError`)。
   * exception表示一种设计和实现问题。exception有两个分支：exception直接子类（受检异常），RuntimeException（运行时异常）。
     * 受检异常：Java 代码在编译过程中，如果受检查异常**没有被 `catch`或者`throws` 关键字处理**的话，就没办法通过编译。常见有IO相关异常。
     * 运行时异常：有编程错误导致的异常，不受检查也可通过编译。常见有：
       * NullPointerException`(空指针错误)，`
       * IllegalArgumentException`(参数错误比如方法入参类型错误)，`
       * NumberFormatException`（字符串转换为数字格式错误，`IllegalArgumentException`的子类），`
       * ArrayIndexOutOfBoundsException`（数组越界错误），`
       * ClassCastException`（类型转换错误）`
       * ArithmeticException`（算术错误）
2. 异常处理机制与关键字
   * 异常捕捉：try/catch finally，如果对象实现了AutoClosable或者Closable接口，可以用try-with-resourses代替。
     * `try`块：用于捕获异常。其后可接零个或多个 `catch` 块，如果没有 `catch` 块，则必须跟一个 `finally` 块。
     * `catch`块：用于处理 try 捕获到的异常。
     * `finally` 块：无论是否捕获或处理异常，`finally` 块里的语句都会被执行。当在 `try` 块或 `catch` 块中遇到 `return` 语句时，`finally` 语句块将在方法返回之前被执行。
   * 异常抛出：throws
     * 当我们在方法中抛出任何已检查的异常而不处理它时，需要在方法签名中使用throws关键字让调用者程序知道该方法可能抛出的异常，调用者可以处理这些异常或者使用thorws将其传播给其他方法。throws表示出现异常的一种可能性，不一定会发送异常。
   * 异常抛出：throw
     * 用在函数内，后面跟异常对象，用来抛出具体的异常对象，执行到throw，方法就结束了，跳转到调用者，并将具体的问题对象抛给调用者。执行throw表示抛出了异常。

### 11. 反射

1. 什么是反射？
   * 反射就是把java中的各个成分映射成一个个的java对象（field,method,constructor）。即在运行中，对于任意一个类，都可以知道这个类的属性和方法，对于任意一个对象，都能够调用它的任意一个属性和方法。反射赋予了运行时分析类以及调用类中方法的能力。
2. 反射的作用：
   * 运行时探查类的信息：反射允许我们在运行时加载、检查和使用类，甚至可以在运行时获取一个未加载的类。
   * 动态创建对象：使用反射可以实现动态地创建对象，而且可以选择该类的任意一个构造函数来创建对象实例。
   * 访问或修改私有成员：反射可以访问和修改一个类中私有的字段和方法，即使这些字段和方法是私有的。
   * 扩展应用程序的可控性：反射可以提高应用程序的可扩展性，例如，它可以读取配置文件来决定需要加载哪个类。
3. 反射的特点：动态性，类型检查问题，性能问题，安全性问题
4. 反射使用场景：
   1. 动态加载类，可以使用[类加载器](https://so.csdn.net/so/search?q=类加载器&spm=1001.2101.3001.7020)动态加载要使用的类，而不是在编译期间声明对该类的依赖关系。
   2. 获取类的信息
   3. 通过名称调用方法或访问类名
   4. 动态代理：使用反射可以实现动态代理，即在运行时动态地创建一个实现某个接口的代理类，从而实现一些特殊的功能，如事务处理等。
5. 反射使用：
   1. 获取class对象：
      * 通过类名.class
      * Class.forName()
      * instance.getclass()
      * 类加载器传入类路径
   2. 获取field,method,constructor
   3. 设置属性值，调用方法（invoke），创建对象
6. 动态代理：
   * 代理模式：**使用代理对象来代替对真实对象的访问，这样就可以在不修改原目标对象的前提下，提供额外的功能操作，扩展目标对象的功能。**代理模式的主要作用是扩展目标对象的功能，比如说在目标对象的某个方法执行前后你可以增加一些自定义的操作。
   * JVM代理使用：
     * 定义一个接口及其实现类。
     * 自定义InvocationHandler并重写invoke方法，invoke参数（proxy，method，args），在invoke中会调用原生方法并在方法的前后添加处理逻辑。
     * 通过 `Proxy.newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h)` 方法创建代理对象；loader传入接口实现类的类加载器，interface传入接口的列表，这两个参数都依靠反射传入。

### 12. 集合![Java 集合框架概览](https://oss.javaguide.cn/github/javaguide/java/collection/java-collection-hierarchy.png)

1. Vector，ArrayList和LinkedList
   - **是否保证线程安全：** `ArrayList` 和 `LinkedList` 都是不同步的，也就是不保证线程安全；Vector线程安全，使用synchronized同步。
   - **底层数据结构：** `ArrayList` 底层使用的是 **`Object` 数组**；`LinkedList` 底层使用的是 **双向链表** 数据结构
   - **插入和删除是否受元素位置的影响：**
   - **是否支持快速随机访问：** `LinkedList` 不支持高效的随机元素访问，而 `ArrayList`（实现了 `RandomAccess` 接口） 支持。快速随机访问就是通过元素的序号快速获取元素对象
   - **内存空间占用：**`ArrayList` 的空间浪费主要体现在在 list 列表的结尾会预留一定的容量空间，而 LinkedList 的空间花费则体现在它的每一个元素都需要消耗比 ArrayList 更多的空间

2. ArrayList扩容机制

   1. 重要类成员变量：

      ```java
      private static final int DEFAULT_CAPACITY = 10;   //默认最小容量
      private static final Object[] EMPTY_ELEMENTDATA = {};	//空数组，用于表示带参构造时传入容量为0
      private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};  //空数组，表示空参构造
      transient Object[] elementData;	//保存数据的数组
      private int size;	//元素个数
      ```

   2. 三种构造函数：

      * 空参构造：elementData指向DEFAULTCAPACITY_EMPTY_ELEMENTDATA。
      * 带参构造（int initialCapacity）：参数为0则elementData指向EMPTY_ELEMENTDATA，否则创建新数组新数组长度为传入的capacity。
      * 带参构造（Collection）：如果传入集合长度为0则elementData指向EMPTY_ELEMENTDATA，否则调用toArray方法将传入集合转为数组。

   3. 扩容机制：

      * add/addALL时，先调用ensureCapacityInternal(size + 1)/(size+e.length)，该方法是计算minCapacity并调用ensureExplicitCapacity判断是否需要扩容。计算minCapacity时，先判断数组是否为DEFAULTCAPACITY_EMPTY_ELEMENTDATA，如果是则minCapacity = max{DEFAULT_CAPACITY ,minCapacity}。
      * 确定minCapacity后与elementData.length比较，若数组装不下，则调用grow方法进行扩容。
      * grow方法中，newCapacity=max{minCapacity，1.5*elementData.length}，再比较是否newCapacity>MAX_ARRAY_SIZE=Integer.MAXVALUE-8,如果满足则newCapacity=Integer.MAXVALUE，不满足则不变。确定newCapacity后调用Arrays.copyOf进行扩容与复制。
      * **也就是说，空参构造后的首次扩容，若增加元素个数len小于等于10则扩容至10，否则扩容至len。**
      * **其他的扩容，若增加元素个数len小于等于1.5倍老容量，则扩容至1.5倍老容量，否则扩容至len。**
      * **如果新容量大于Integer.MAXVALUE-8，则扩容至Integer.MAXVALUE。**

3. HashSet,LinkedHashSet和TreeSet

   * `HashSet`、`LinkedHashSet` 和 `TreeSet` 都是 `Set` 接口的实现类，都能保证元素唯一，并且都不是线程安全的。
   * `HashSet`、`LinkedHashSet` 和 `TreeSet` 的主要区别在于底层数据结构不同。`HashSet` 的底层数据结构是哈希表（基于 `HashMap` 实现）。`LinkedHashSet` 的底层数据结构是链表和哈希表，元素的插入和取出顺序满足 FIFO。`TreeSet` 底层数据结构是红黑树，元素是有序的，排序的方式有自然排序和定制排序。
   * 底层数据结构不同又导致这三者的应用场景不同。`HashSet` 用于不需要保证元素插入和取出顺序的场景，`LinkedHashSet` 用于保证元素的插入和取出顺序满足 FIFO 的场景，`TreeSet` 用于支持对元素自定义排序规则的场景。

4. HashTable和HashMap

   * **线程是否安全：** `HashMap` 是非线程安全的，`Hashtable` 是线程安全的,因为 `Hashtable` 内部的方法基本都经过`synchronized` 修饰。
   * **效率：** 因为线程安全的问题，`HashMap` 要比 `Hashtable` 效率高一点。`Hashtable` 基本被淘汰；
   * **对 Null key 和 Null value 的支持：**`HashMap` 可以存储 null 的 key 和 value，但 null 作为键只能有一个，null 作为值可以有多个；Hashtable 不允许有 null 键和 null 值
   * **初始容量大小和每次扩充容量大小的不同：** ① 创建时如果不指定容量初始值，`Hashtable` 默认的初始大小为 11，之后每次扩充，容量变为原来的 2n+1。`HashMap` 默认的初始化大小为 16。之后每次扩充，容量变为原来的 2 倍。② 创建时如果给定了容量初始值，那么 `Hashtable` 会直接使用你给定的大小，而 `HashMap` 会将其扩充为 2 的幂次方大小
   * **底层数据结构：** JDK1.8 以后的 `HashMap` 在解决哈希冲突时有了较大的变化，当链表长度大于阈值（默认为 8）时，将链表转化为红黑树，以减少搜索时间。`Hashtable` 没有这样的机制。

5. HashSet原理

   1. 重要类属性

      ```java
      	 // 默认的初始容量是16
          static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
          // 最大容量
          static final int MAXIMUM_CAPACITY = 1 << 30;
          // 默认的负载因子
          static final float DEFAULT_LOAD_FACTOR = 0.75f;
          // 当桶(bucket)上的结点数大于等于这个值时会转成红黑树
          static final int TREEIFY_THRESHOLD = 8;
          // 当桶(bucket)上的结点数小于等于这个值时树转链表
          static final int UNTREEIFY_THRESHOLD = 6;                                                      
          // 桶中结构转化为红黑树对应的table的最小容量
          static final int MIN_TREEIFY_CAPACITY = 64;
          // 存储元素的数组，总是2的幂次倍
          transient Node<k,v>[] table;
          // 一个包含了映射中所有键值对的集合视图
          transient Set<map.entry<k,v>> entrySet;
          // 存放元素的个数，注意这个不等于数组的长度。
          transient int size;
          // 每次扩容和更改map结构的计数器
          transient int modCount;
          // 阈值(容量*负载因子) 当实际大小超过阈值时，会进行扩容
          int threshold;
          // 负载因子
          final float loadFactor;
      }
      ```

   2. 构造方法

      ```java
          // 默认构造函数。
          public HashMap() {
              this.loadFactor = DEFAULT_LOAD_FACTOR; // all   other fields defaulted
           }
      
           // 包含另一个“Map”的构造函数
           public HashMap(Map<? extends K, ? extends V> m) {
               this.loadFactor = DEFAULT_LOAD_FACTOR;
               putMapEntries(m, false);
           }
      
           // 指定“容量大小”的构造函数
           public HashMap(int initialCapacity) {
               this(initialCapacity, DEFAULT_LOAD_FACTOR);
           }
      
           // 指定“容量大小”和“负载因子”的构造函数
           public HashMap(int initialCapacity, float loadFactor) {
               if (initialCapacity < 0)
                   throw new IllegalArgumentException("Illegal initial capacity: " + initialCapacity);
               if (initialCapacity > MAXIMUM_CAPACITY)
                   initialCapacity = MAXIMUM_CAPACITY;
               if (loadFactor <= 0 || Float.isNaN(loadFactor))
                   throw new IllegalArgumentException("Illegal load factor: " + loadFactor);
               this.loadFactor = loadFactor;
               // 初始容量暂时存放到 threshold ，在resize中再赋值给 newCap 进行table初始化，该方法返回最接近initialCapacity的2的幂次
               this.threshold = tableSizeFor(initialCapacity);
           }
      
      
      	final void putMapEntries(Map<? extends K, ? extends V> m, boolean evict) {
          int s = m.size();
          if (s > 0) {
              // 判断table是否已经初始化
              if (table == null) { // pre-size
                  /*
                   * 未初始化，s为m的实际元素个数，ft=s/loadFactor => s=ft*loadFactor, 跟我们前面提到的
                   * 阈值=容量*负载因子 是不是很像，是的，ft指的是要添加s个元素所需的最小的容量
                   */
                  float ft = ((float)s / loadFactor) + 1.0F;
                  int t = ((ft < (float)MAXIMUM_CAPACITY) ?
                          (int)ft : MAXIMUM_CAPACITY);
                  /*
                   * 根据构造函数可知，table未初始化，threshold实际上是存放的初始化容量，如果添加s个元素所
                   * 需的最小容量大于初始化容量，则将最小容量扩容为最接近的2的幂次方大小作为初始化。
                   * 注意这里不是初始化阈值
                   */
                  if (t > threshold)
                      threshold = tableSizeFor(t);
              }
              // 已初始化，并且m元素个数大于阈值，进行扩容处理
              else if (s > threshold)
                  resize();
              // 将m中的所有元素添加至HashMap中，如果table未初始化，putVal中会调用resize初始化或扩容
              for (Map.Entry<? extends K, ? extends V> e : m.entrySet()) {
                  K key = e.getKey();
                  V value = e.getValue();
                  putVal(hash(key), key, value, false, evict);
              }
          }
      }
      
      ```

      * 总的来说，调用构造方法如果没有传入负载因子，则会使用默认负载因子进行初始化，否则初始化为传入的负载因子。
      * 如果传入初始容量，则会调用tableSizeFor寻找最接近的2的幂次，以这个值初始化thread。
      * 如果传入一个Map，调用putMapEntries，计算map.size()/loadFactor得到最小容量ft，调用tableSizeFor寻找最接近与ft的2的幂次，保存与thread中。之后遍历传入的Map，使用putVal方法将所有键值对转移到新的数组中。

   3. put方法

      ![ ](https://oss.javaguide.cn/github/javaguide/database/sql/put.png)

   4. get方法

      * 计算hash索引判断桶是否为空，不为空则判断与首节点是否相等（使用equals），不相等则遍历next节点，如果为红黑树则使用红黑树的get，如果不是红黑树则遍历链表。

   5. resize方法

      ```java
      final Node<K,V>[] resize() {
          Node<K,V>[] oldTab = table;
          int oldCap = (oldTab == null) ? 0 : oldTab.length;
          int oldThr = threshold;
          int newCap, newThr = 0;
          if (oldCap > 0) {
              // 超过最大值就不再扩充了
              if (oldCap >= MAXIMUM_CAPACITY) {
                  threshold = Integer.MAX_VALUE;
                  return oldTab;
              }
              // 没超过最大值，就扩充为原来的2倍
              else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY && oldCap >= DEFAULT_INITIAL_CAPACITY)
                  newThr = oldThr << 1; // double threshold
          }
          else if (oldThr > 0) // initial capacity was placed in threshold
              // 创建对象时初始化容量大小放在threshold中，此时只需要将其作为新的数组容量
              newCap = oldThr;
          else {
              // signifies using defaults 无参构造函数创建的对象在这里计算容量和阈值，容量为16，阈值为12
              newCap = DEFAULT_INITIAL_CAPACITY;
              newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
          }
          if (newThr == 0) {
              // 创建时指定了初始化容量或者负载因子，在这里进行阈值初始化，
          	// 或者扩容前的旧容量小于16，在这里计算新的resize上限
              float ft = (float)newCap * loadFactor;
              newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ? (int)ft : Integer.MAX_VALUE);
          }
          threshold = newThr;
          @SuppressWarnings({"rawtypes","unchecked"})
              Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
          table = newTab;
          if (oldTab != null) {
              // 把每个bucket都移动到新的buckets中
              for (int j = 0; j < oldCap; ++j) {
                  Node<K,V> e;
                  if ((e = oldTab[j]) != null) {
                      oldTab[j] = null;
                      if (e.next == null)
                          // 只有一个节点，直接计算元素新的位置即可
                          newTab[e.hash & (newCap - 1)] = e;
                      else if (e instanceof TreeNode)
                          // 将红黑树拆分成2棵子树，如果子树节点数小于等于 UNTREEIFY_THRESHOLD（默认为 6），则将子树转换为链表。
                          // 如果子树节点数大于 UNTREEIFY_THRESHOLD，则保持子树的树结构。
                          ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
                      else {
                          Node<K,V> loHead = null, loTail = null;
                          Node<K,V> hiHead = null, hiTail = null;
                          Node<K,V> next;
                          do {
                              next = e.next;
                              // 原索引
                              if ((e.hash & oldCap) == 0) {
                                  if (loTail == null)
                                      loHead = e;
                                  else
                                      loTail.next = e;
                                  loTail = e;
                              }
                              // 原索引+oldCap
                              else {
                                  if (hiTail == null)
                                      hiHead = e;
                                  else
                                      hiTail.next = e;
                                  hiTail = e;
                              }
                          } while ((e = next) != null);
                          // 原索引放到bucket里
                          if (loTail != null) {
                              loTail.next = null;
                              newTab[j] = loHead;
                          }
                          // 原索引+oldCap放到bucket里
                          if (hiTail != null) {
                              hiTail.next = null;
                              newTab[j + oldCap] = hiHead;
                          }
                      }
                  }
              }
          }
          return newTab;
      }
      
      ```

      1. **确定新容量和阈值**
         - `oldCap` 是旧的容量（数组长度）。
         - `oldThr` 是旧的阈值（容量乘以负载因子）。
         - 如果旧的容量大于0，则新容量是旧容量的两倍。如果新的容量超过最大容量限制，则直接返回旧的数组。
         - 如果旧的容量为0但旧的阈值大于0，则新的容量设为旧的阈值。
         - 否则，使用默认初始容量和默认负载因子。
      2. **创建新数组**
         - 根据计算出的新容量，分配新的桶数组，并更新阈值。

      3. **重新分配元素**

         - 遍历旧数组中的每个桶。

         - 如果桶中的节点是单个节点，直接计算其在新数组中的位置并放置。

         - 如果桶中的节点是红黑树节点，调用`split`方法进行分割。
           - split方法：重新计算hash索引，如果对旧容量取模为0，则代表位置不变，如果不为0则代表位置增加oldCap，以此分为高位链表和低位链表。分别对低位链表和高位链表处理，若节点数小于阈值6，则退化为链表，否则将链表进行树化转为红黑树。

         - 如果桶中的节点是链表节点，则将其拆分为两个链表高位链表和低位链表，一个链表保留原索引位置，一个链表索引位置增加oldCap。

### 13. volatile关键字

1. JMM和指令重排序
   * JMM是一种内存模型，用来屏蔽掉各种硬件和操作系统之间的差异，让java程序在各种平台下都能达成一致的访问效果。JMM规定所有的变量（此处的变量不包括局部变量和方法参数）都存储于主内存中，每条线程又有自己的工作内存，线程的工作内存保存了被该线程使用到的变量的主内存副本拷贝。线程对变量的所有操作都必须在工作内存中进行，而不能直接读写主内存中的变量。主内存直接对应于物理内存，而工作内存可能会优先存储于寄存器和高速缓存。JMM定义了8种原子操作来进行主内存与工作内存之间的交互。
   * 为了使得处理器内部运算单元能够被充分利用，处理器可能会对代码乱序执行，java虚拟机也会有指令重排序的优化。
2. volatile关键字的特殊规则
   * 保证变量的可见性，可见性指一条线程修改了这个变量的值，另外的线程是可以立即得知的（普通变量的值在线程中传递需要通过主内存来完成）。如果我们将变量声明为 **`volatile`** ，这就指示 JVM，这个变量是共享且不稳定的，每次使用它都到主存中进行读取。
   * **防止 JVM 的指令重排序。** 如果我们将变量声明为 **`volatile`** ，在对这个变量进行读写操作的时候，会通过插入特定的 **内存屏障** 的方式来禁止指令重排序。
3. volatile不保证原子性。

### 14. synchronized同步

1. 用法
   * 修饰实例方法：调用方法要获取内部对象锁。
   * 修饰静态方法：获取.class对象锁。
   * 修饰代码块：获取给定对象的锁。

2. 原理：

   * 在jdk1.5（包含）版本之前，因为加锁和释放锁的过程JVM的底层都是由操作系统mutex lock来实现的，其中会涉及上下文的切换（即用户态和内核态的转换），性能消耗极其高，所以在当时synchronized锁是公认的重量级锁。后来JVM开发团队为解决性能问题，在jdk1.5版本中加入了JUC并发包，包下开发了很多Lock相关的锁，来解决同步的性能问题，同时也开始在后续的迭代版本中对synchronized锁不断的进行优化来提高性能，比如在jdk1.6版本中就引入了“偏向锁”和“轻量级锁”，通过锁的升级来解决不同并发场景下的性能问题。

   1. 锁的状态：

      * 对象头：一部分存储对象自身的运行时数据，称为mark word。一部分存储指向方法区对象类型数据的指针；如果是数组对象，还有一个额外的部分用于存储数组长度。
   
      1. 无锁：偏向锁标识位是0，锁标识位是01。
      2. 偏向锁：当一个共享资源首次被某个线程访问时，锁就会从无锁状态升级到偏向锁状态，偏向锁会在Markword的偏向线程ID里存储当前线程的操作系统线程ID，偏向锁标识位是1，锁标识位是01。
   2. 轻量级锁：Markword存储指向Lock Record的指针，锁标志位是00。
      4. 重量级锁：Markword存储指向monitor对象的地址，标志位10。

   3. 锁升级过程

      1. **当JVM启动后，一个共享资源对象直到有线程第一个访问时，这段时间内是处于无锁状态**.
      2. 当锁对象第一次被线程获取时，虚拟机会将标志位置为01，偏向模式。同时使用CAS操作把获取到这个锁的ID记录在markword中，如果CAS成功，持有偏向锁的线程以后每次进入同步代码块时都可以不再进行任何同步操作。**当有另外一个线程尝试去获取这个锁时，偏向模式宣告结束，撤销偏向锁。根据锁对象是否处于被锁定状态，分别转为无锁和轻量级锁。**
         另外需要注意的是，由于硬件资源的不断升级，获取锁的成本随之下降，jdk15版本后默认关闭了偏向锁。如果未开启偏向锁（或者在JVM偏向锁延迟时间之前）有线程访问共享资源则直接由无锁升级为轻量级锁。
   
      3. 升级轻量级锁时，虚拟机会在当前线程的栈帧中建立一个名为锁记录的空间，用于存储当前锁对象的markword的拷贝。然后，虚拟机使用CAS操作尝试将对象的mark word更新为指向锁记录的指针。若更新成功，则升级成功，锁标志被更新为00；若更新失败，虚拟机会检查此时mark word 是否指向当前栈帧，如果是表明当前线程已经拥有了这个对象锁，那么就可以直接进入同步块。如果不知向当前栈帧，则说明被其他线程抢占，此时膨胀为重量级锁。
   
      4. 当轻量级锁获取锁失败时，说明有竞争存在，轻量级锁会升级为重量级锁，重量级锁的Markword里存储的指针会被改为指向monitor对象。此时，JVM会将线程阻塞，直到获取到锁后才能进入临界区域，底层是通过操作系统的mutex lock来实现的。将monitorenter指令插入到同步代码块在编译后的开始位置，monitorexit指令插入到同步代码块的结束处和异常处，这两个指令配对出现。执行monitorenter时，尝试获取对象锁，如果获取成功，锁计数器加一，执行monitorexit时锁计数器减一，当计数器为0时锁被释放，以此实现可重入。
   

### 15. ReentrantLock同步

1. ReentrantLock

   * `ReentrantLock` 实现了 `Lock` 接口，是一个可重入且独占式的锁，和 `synchronized` 关键字类似。不过，`ReentrantLock` 更灵活、更强大，增加了轮询、超时、中断、公平锁和非公平锁等高级功能。`ReentrantLock` 里面有一个内部类 `Sync`，`Sync` 继承 AQS（`AbstractQueuedSynchronizer`），添加锁和释放锁的大部分操作实际上都是在 `Sync` 中实现的。`Sync` 有公平锁 `FairSync` 和非公平锁 `NonfairSync` 两个子类。

   * 与synchronized比较：

     * 都是可重入锁。

     * `synchronized` 是依赖于 JVM 实现的，前面我们也讲到了 虚拟机团队在 JDK1.6 为 `synchronized` 关键字进行了很多优化，但是这些优化都是在虚拟机层面实现的，并没有直接暴露给我们。

       `ReentrantLock` 是 JDK 层面实现的（也就是 API 层面，需要 lock() 和 unlock() 方法配合 try/finally 语句块来完成），所以我们可以通过查看它的源代码，来看它是如何实现的。

     * **等待可中断** : `ReentrantLock`提供了一种能够中断等待锁的线程的机制，通过 `lock.lockInterruptibly()` 来实现这个机制。也就是说正在等待的线程可以选择放弃等待，改为处理其他事情。

     * **可实现公平锁** : `ReentrantLock`可以指定是公平锁还是非公平锁。而`synchronized`只能是非公平锁。所谓的公平锁就是先等待的线程先获得锁。`ReentrantLock`默认情况是非公平的，可以通过 `ReentrantLock`类的`ReentrantLock(boolean fair)`构造方法来指定是否是公平的。

     * **可实现选择性通知（锁可以绑定多个条件）**: `synchronized`关键字与`wait()`和`notify()`/`notifyAll()`方法相结合可以实现等待/通知机制。`ReentrantLock`类当然也可以实现，但是需要借助于`Condition`接口与`newCondition()`方法。

2. ReentrantReadWriteLock

   * `ReentrantReadWriteLock` 其实是两把锁，一把是 `WriteLock` (写锁)，一把是 `ReadLock`（读锁） 。读锁是共享锁，写锁是独占锁。读锁可以被同时读，可以同时被多个线程持有，而写锁最多只能同时被一个线程持有。

### 16. CAS非阻塞同步

1. 概念：
   * 悲观锁：互斥同步最主要的问题就是进行线程阻塞唤醒所带来的性能问题，互斥同步属于一种悲观锁。悲观锁认为无论数据是否会出现竞争，都需要先加锁在进行特定操作。
   * 乐观锁：先进行操作，再进行冲突检测。先操作，如果没有其他线程产生竞争，那么操作成功，否则再采取其他措施（通常是重试），乐观锁不需要把线程挂起，所以也叫非阻塞同步。
2. 原理：
   * **非阻塞同步需要操作数据检测冲突这两个步骤具有原子性**，这是借助于硬件层面来实现的，硬件层面提供了一些原子操作指令，如TAS和CAS等。
   * CAS，比较并交换，有三个操作数，内存位置、预期值、新值。执行CAS时，只有当前值等于预期值，才会设置为新值。无论是否设置成功，都返回旧值。
3. java中的CAS使用：java中的Unsafe类提供了compareAndSwapInt等方法，虚拟机内部对这些方法做了处理，使得这些方法的编译结果就是一条相关的CAS指令，没有方法调用的过程。
4. Atomic原子类

   * 利用volatile和CAS而没有使用锁，提供了一些如AddAndGet()等原子方法操作数值。
   * 基本类型：AtomicInteger,AtomicLong,AtomicBoolean.提供了GetAndSet等原子操作。
   * 数组类型：使用原子的方式更新数组里的某个元素。AtomicIntegerArray,AtomicLongArray,AtomicBooleanArray.
   * 引用类型：把对象设置进原子类引用对象中，使用CAS设置。AtomicReference，AtomicStampedReference（带有版本号的引用类型）。
5. CAS问题：
   1. ABA问题：一个变量被初次读取时值为A，准备赋值时值依然为A，CAS不能知道这段时间这个变量是否被修改过。可通过版本号或时间戳解决，JUC提供了一个AtomicStampedReference原子引用类，通过控制变量的版本值解决ABA问题。
   2. 自旋问题：CAS常用到自旋来重试，自旋会使CPU空转，浪费CPU资源。
   3. 只能保证一个共享变量的原子操作：可以使用`AtomicReference`类来保证引用对象之间的原子性，你可以把多个变量放在一个对象里来进行 CAS 操作.所以我们可以使用锁或者利用`AtomicReference`类把多个共享变量合并成一个共享变量来操作。

### 17. JUC并发容器

1. ConcurrentHashMap

   1. 区别:
      1. Java7 中 `ConcurrentHashMap` 使用的分段锁，也就是每一个 Segment 上同时只有一个线程可以操作，每一个 `Segment` 都是一个类似 `HashMap` 数组的结构，它可以扩容，它的冲突会转化为链表。但是 `Segment` 的个数一但初始化就不能改变。
      2. Java8 中的 `ConcurrentHashMap` 使用的 `Synchronized` 锁加 CAS 的机制。结构 进化成了 **Node 数组 + 链表 / 红黑树**，Node 是类似于一个 HashEntry 的结构。它的冲突再达到一定大小时会转化成红黑树，在冲突小于一定数量时又退回链表。

   2. 构造方法：

      * sizeCtl与HashMap类似，可选择空参构造或者带参构造。如果使用带参构造传入容量，则会计算最小的大于传入容量的2的幂次，并初始化。

   3. 初始化方法initTable：表的真正初始化是在添加元素后进行的
      * 初始化通过自旋和CAS操作完成，变量sizeCtl控制初始化状态：
        * sizeCtl<0,另外的线程正在初始化，当前线程让出CPU。
        * sizeCtl>=0，没有线程正在进行初始化，通过CAS设置sizeCtl值为-1，表示由当前线程初始化.如果sizeCtl=0则初始容量为DEFAULT_CAPACITY，否则为sizeCtl。然后创建对应容量大小的数组。

   4. put方法：与HashMap类似，区别在于写入数据时需要同步。

      * 如果数组未初始化，即数组为空或者长度为0，则调用initTable进行初始化。

      * 计算当前key属于哪一个桶，如果桶为空，使用CAS直接放入。
      * 如果桶不为空，使用synchronized获取该桶的首节点锁，再进行类似于HashMap的插入（链表插入、红黑树插入、链表转换...检查扩容条件）

   5. 扩容：当元素个数达到阈值时调用transfer方法扩容

      1. 初始化新表：如果nextTab为Null，则创建一个容量为旧表两倍的新表nextTab。
      2. 数据迁移：
         1. 初始化变量，比如 `stride` 用于分段迁移的步长，`fwd` 是前导节点，用于指示已经迁移完成的桶。
         2. 使用transferIndex变量来记录工作进度，使用CAS来设置transferIndex进行多线程同时迁移时的同步，每次迁移一个步长的桶。
         3. 处理桶的元素：如果当前桶为空，设置fwd节点指向该桶表示以处理；如果当前桶以迁移，跳过；否则，使用synchronized锁定当前桶并迁移，迁移过程与HashMap类似。
      3. 结束扩容：清理标记，将table指向新表，nextTab置为null，更行sizeCtr为新表容量。

2. CopyOnWriteArrayList

   * 在 JDK1.5 之前，如果想要使用并发安全的 `List` 只能选择 `Vector`。而 `Vector` 是一种老旧的集合，已经被淘汰。`Vector` 对于增删改查等方法基本都加了 `synchronized`，这种方式虽然能够保证同步，但这相当于对整个 `Vector` 加上了一把大锁，使得每个方法执行的时候都要去获得锁，导致性能非常低下。
   * JDK1.5 引入了 `Java.util.concurrent`（JUC）包，其中提供了很多线程安全且并发性能良好的容器，其中唯一的线程安全 `List` 实现就是 `CopyOnWriteArrayList` 。
   * `CopyOnWriteArrayList` 线程安全的核心在于其采用了 **写时复制（Copy-On-Write）** 的策略,
   * 当需要修改（ `add`，`set`、`remove` 等操作） `CopyOnWriteArrayList` 的内容时，不会直接修改原数组，而是会先创建底层数组的副本，对副本数组进行修改，修改完之后再将修改后的数组赋值回去，这样就可以保证写操作不会影响读操作了。即只有写写操作会互斥。

3. ConcurrentLinkedQueue

   * 非阻塞队列，使用链表作为底层数据结构，使用CAS来实现线程安全， 拥有较高的并发性能，内部实现复杂。

4. BlockingQueue

   1. 作用：阻塞队列（`BlockingQueue`）是一个接口，被广泛使用在“生产者-消费者”问题中，其原因是 `BlockingQueue` 提供了可阻塞的插入和移除的方法。当队列容器已满，生产者线程会被阻塞，直到队列未满；当队列容器为空时，消费者线程会被阻塞，直至队列非空时为止。有三个常见实现类：ArrayBlockingQueue，LinkedBlockingQueue，PriorityBlockingQueue。

   2. ArrayBlockingQueue

      * `ArrayBlockingQueue` 一旦创建，容量不能改变。其并发控制采用可重入锁 `ReentrantLock` ，不管是插入操作还是读取操作，都需要获取到锁才能进行操作。当队列容量满时，尝试将元素放入队列将导致操作阻塞;尝试从一个空队列中取一个元素也会同样阻塞。
      * `ArrayBlockingQueue` 默认情况下不能保证线程访问队列的公平性。

   3. LinkedBlockingQueue

      * `LinkedBlockingQueue` 底层基于**单向链表**实现的阻塞队列，可以当做无界队列也可以当做有界队列来使用，同样满足 FIFO 的特性，与 `ArrayBlockingQueue` 相比起来具有更高的吞吐量，为了防止 `LinkedBlockingQueue` 容量迅速增，损耗大量内存。通常在创建 `LinkedBlockingQueue` 对象时，会指定其大小，如果未指定，容量等于 `Integer.MAX_VALUE` 

   4. PriorityBlockingQueue

      * `PriorityBlockingQueue` 是一个支持优先级的无界阻塞队列。默认情况下元素采用自然顺序进行排序，也可以通过自定义类实现 `compareTo()` 方法来指定元素排序规则，或在构造方法中传入 `Comparator` 来指定排序规则。

        `PriorityBlockingQueue` 并发控制采用的是可重入锁 `ReentrantLock`，队列为无界队列，只能指定初始的队列大小，后面插入元素的时候，**如果空间不够的话会自动扩容**。

        简单地说，它就是 `PriorityQueue` 的线程安全版本。不可以插入 null 值，同时，插入队列的对象必须是可比较大小的（comparable），否则报 `ClassCastException` 异常。它的插入操作 put 方法不会 block，因为它是无界队列（take 方法在队列为空的时候会阻塞）。

### 18. AQS

1. 概念

   * 全称为 `AbstractQueuedSynchronizer` ，翻译过来的意思就是抽象队列同步器。是一个抽象类，用于构建锁和同步器。主要是通过继承方式使用，本身没有实现任何接口，仅仅是定义了同步状态的获取和释放的方法。AQS解决实现同步器的大量细节问题，例如获取同步状态，FIFO队列，入队和出队。自定义同步器在实现时候只需要实现共享资源state的获取和释放即可，至于获取资源失败入队/唤醒出队等，AQS在顶层已经定义好了。ReentrantLock`，`Semaphore，downtownLatch等都是通过AQS实现。

2. 实现：

   * AQS内部用一个[volatile](https://so.csdn.net/so/search?q=volatile&spm=1001.2101.3001.7020)修饰的int类型的成员变量state来控制同步状态。状态信息 `state` 可以通过`getState()`、`setState()`和`compareAndSetState()` 进行操作。并且，这几个方法都是 `final` 修饰的，在子类中无法被重写。

   * 同步队列：AQS是依赖内部的同步队列实现，也就是FIFO双向队列，如果当前线程竞争锁失败，那么AQS会把当前线程以及等待状态封装成一个Node节点加入到同步队列中，同时阻塞该线程，当同步状态释放时，会把首节点唤醒，使其再次尝试获取同步状态。
   * 等待队列：ConditionObject是AQS的内部类，等待队列是一个[FIFO](https://so.csdn.net/so/search?q=FIFO&spm=1001.2101.3001.7020)的队列，每个节点都包含一个线程的引用，该线程就是在Condition对象中等待的线程，如果线程调用了await方法，线程将会加入等待线程，释放锁，并进入等待状态。节点都是AQS的静态内部类Node。如果调用await方法，节点加入等待队列，并释放锁，调用signal方法，则将线程移到同步队列队尾，唤醒线程。

3. AQS模式：

   * 独占：实现tryAcquire-tryRelease，初始化state=0，获取锁时通过判断state是否为0，是则设置为1表示获取锁成功，否则阻塞。
   * 共享模式：实现tryAcquireShared-tryReleaseShared，初始化state为n，获取时判断state是否大于0，是则使用CAS将state自减获取成功，否则阻塞。

4. AQS实现ReentrantLock

   * ReentrantLock是可重入独占锁，利用state维护共享状态。当线程调用lock()方法时，ReentrantLock会尝试通过tryAcquire（）获得该锁，利用CAS设置state的值如果成功从0设置为1则获取锁成功，获取失败则加入到等待队列。如果获取成功，此线程再次获取该锁，则将state值加1，实现可重入。在释放锁时，state的值为0才释放完成。

5. AQS实现Semaphor

   * Semaphor是共享锁，state的值初始化为许可证数量。使用CAS操作尝试减少当前许可数量。如果许可不足（remaining < 0），则返回负值，表示获取失败；否则，返回剩余的许可数量。
   * 释放许可证使用release，调用tryReleaseShared，使用CAS将state值加1，并唤醒一个等待线程。被唤醒的线程会重新尝试获取许可证。

6. AQS实现CountDownLatch

   * CountDownLatch允许 `count` 个线程阻塞在一个地方，直至所有线程的任务都执行完毕。
   * CountDownLatch是一种共享锁，当线程使用countDown时，内部调用了`tryReleaseShared`方法以 CAS 的操作来减少 `state`,直至 `state` 为 0 。当调用 `await()` 方法的时候，如果 `state` 不为 0，那就证明任务还没有执行完毕，`await()` 方法就会一直阻塞，也就是说 `await()` 方法之后的语句不会被执行。直到`count` 个线程调用了`countDown()`使 state 值被减为 0，或者调用`await()`的线程被中断，该线程才会从阻塞中被唤醒，`await()` 方法之后的语句得到执行。

### 19. ThreadLocal

1. 作用：
   * **`threadLocal`类主要解决的就是让每个线程绑定自己的值，可以将`ThreadLocal`类形象的比喻成存放数据的盒子，盒子中可以存储每个线程的私有数据。**如果创建了一个`ThreadLocal`变量，那么访问这个变量的每个线程都会有这个变量的本地副本，这也是`ThreadLocal`变量名的由来。他们可以使用 `get()` 和 `set()` 方法来获取默认值或将其值更改为当前线程所存的副本的值，从而避免了线程安全问题。
   * 比如每个线程SimpleDateFormat不同需要创建各自副本，比如为每个线程生成各自的随机数生成器。
   * **每个`Thread`中都具备一个`ThreadLocalMap`，而`ThreadLocalMap`可以存储以`ThreadLocal`为 key ，Object 对象为 value 的键值对。**

### 20. 线程池

1. 概念：线程池就是管理一系列线程的资源池。当有任务要处理时，直接从线程池中获取线程来处理，处理完之后线程并不会立即被销毁，而是等待下一个任务。

2. 作用：

   * 降低资源消耗，通过重复利用降低线程创建和销毁时的消耗。
   * 提高响应速度，任务到达时，可以不需要等待线程创建就立即执行。
   * 提高线程的可管理性。

3. 创建

   1. 通过**`ThreadPoolExecutor`构造函数来创建**。
   2. 通过**`Executor` 框架的工具类 `Executors` 来创建**。（超过任务队列长度会造成OOM错误，不推荐使用）
      * `FixedThreadPool`：固定线程数量的线程池。该线程池中的线程数量始终不变。当有一个新的任务提交时，线程池中若有空闲线程，则立即执行。若没有，则新的任务会被暂存在一个任务队列中，待有线程空闲时，便处理在任务队列中的任务。使用LinkedBlockingQueue，默认是一个无界队列。这意味着队列可以无限增长，可能导致内存耗尽。（解决：使用`ThreadPoolExecutor`时，可以指定一个有界队列，以限制任务队列的大小，从而避免潜在的资源耗尽问题。）
      * `SingleThreadExecutor`： 只有一个线程的线程池。若多余一个任务被提交到该线程池，任务会被保存在一个任务队列中，待线程空闲，按先入先出的顺序执行队列中的任务。使用LinkedBlockingQueue，默认是一个无界队列。这意味着队列可以无限增长，可能导致内存耗尽。
      * `CachedThreadPool`： 可根据实际情况调整线程数量的线程池。线程池的线程数量不确定，但若有空闲线程可以复用，则会优先使用可复用的线程。若所有线程均在工作，又有新的任务提交，则会创建新的线程处理任务。所有线程在当前任务执行完毕后，将返回线程池进行复用。`SynchronousQueue`，允许创建任意数量的线程。如果任务提交速度远大于线程处理速度，会导致创建大量线程，增加系统负载，可能导致`OutOfMemoryError`。（解决：使用`ThreadPoolExecutor`时，可以控制最大线程数，通过合理配置`maximumPoolSize`来限制线程的数量，避免过多线程导致系统资源耗尽。）
      * `ScheduledThreadPool`：给定的延迟后运行任务或者定期执行任务的线程池。使用的无界的延迟阻塞队列`DelayedWorkQueue`，任务队列最大长度为 `Integer.MAX_VALUE`,可能堆积大量的请求，从而导致 OOM。

4. ThreadPoolExecutor参数

   * `corePoolSize` : 任务队列未达到队列容量时，最大可以同时运行的线程数量。
   * `maximumPoolSize` : 任务队列中存放的任务达到队列容量的时候，当前可以同时运行的线程数量变为最大线程数。
   * `workQueue`: 新任务来的时候会先判断当前运行的线程数量是否达到核心线程数，如果达到的话，新任务就会被存放在队列中。

   - `keepAliveTime`:线程池中的线程数量大于 `corePoolSize` 的时候，如果这时没有新的任务提交，核心线程外的线程不会立即销毁，而是会等待，直到等待的时间超过了 `keepAliveTime`才会被回收销毁。
   - `unit` : `keepAliveTime` 参数的时间单位。
   - `threadFactory` :executor 创建新线程的时候会用到。
   - `handler` :拒绝策略

5. 拒绝策略

   * `ThreadPoolExecutor.AbortPolicy`：抛出 `RejectedExecutionException`来拒绝新任务的处理。
   * `ThreadPoolExecutor.CallerRunsPolicy`：调用执行自己的线程运行任务，也就是直接在调用`execute`方法的线程中运行(`run`)被拒绝的任务，如果执行程序已关闭，则会丢弃该任务。因此这种策略会降低对于新任务提交速度，影响程序的整体性能。如果你的应用程序可以承受此延迟并且你要求任何一个任务请求都要被执行的话，你可以选择这个策略。
   * `ThreadPoolExecutor.DiscardPolicy`：不处理新任务，直接丢弃掉。
   * `ThreadPoolExecutor.DiscardOldestPolicy`：此策略将丢弃最早的未处理的任务请求。

6. 阻塞队列

   * ArrayBlockingQueue:有界队列，按FIFO进行排列.适用于需要有界队列场景，防止任务堆积导致内存溢出。
   * LinkedBlockingQueue：可选有界队列，FIFO，可传入容量，默认容量为Integer.MAX_VALUE.适用于较高并发量的场景，默认无界。
   * SynchronousQueue: 同步队列，`SynchronousQueue` 没有容量，不存储元素，目的是保证对于提交的任务，如果有空闲线程，则使用空闲线程来处理；否则新建一个线程来处理任务。适用于任务提交速度和任务处理速度相同的场景，通常用于直接传递任务给工作线程。
   * PriorityBlokingQueue: 优先级阻塞队列，元素顺序可通过传入Comparator决定。适用于需要处理优先级的场景。
   * DelayedWorkQueue(延迟阻塞队列)：内部元素并不是按照放入的时间排序，而是会按照延迟的时间长短对任务进行排序，内部采用的是“堆”的数据结构，可以保证每次出队的任务都是当前队列中执行时间最靠前的。`DelayedWorkQueue` 添加元素满了之后会自动扩容原来容量的 1/2，即永远不会阻塞，最大扩容可达 `Integer.MAX_VALUE`，所以最多只能创建核心线程数的线程。

7. 任务处理流程

![图解线程池实现原理](https://oss.javaguide.cn/github/javaguide/java/concurrent/thread-pool-principle.png)

```java
public void execute(Runnable command) {
    // 如果task为null, 抛出
    if (command == null)
        throw new NullPointerException();
    
    // 获得ctl的int值
    int c = ctl.get();
    // workerCount小于corePoolSize
    if (workerCountOf(c) < corePoolSize) {
        // 添加一个新的worker, 作为核心线程池的线程
        if (addWorker(command, true))
            // 添加worker作为核心线程成功, execute方法退出
            return;
        // 添加worker作为核心线程失败, 重新获取ctl的int值
        c = ctl.get();
    }
    // 线程池是RUNNING状态并且task入阻塞队列成功
    if (isRunning(c) && workQueue.offer(command)) {
        // 二次检测, 再次获取ctl的值
        int recheck = ctl.get();
        // 线程池不是RUNNING状态并且当前task从workerQueue被移除成功
        if (! isRunning(recheck) && remove(command))
            // 执行拒绝策略
            reject(command);
        // 线程池中的workerCount为0
        else if (workerCountOf(recheck) == 0)
            // 启动一个非核心线程, 由于这里的task参数为null, 该线程会从workerQueue拉去任务
            addWorker(null, false);
    }
    // 添加一个非核心线程执行
    else if (!addWorker(command, false))
        // 添加一个非核心线程失败, 执行拒绝策略
        reject(command);
}
```

```java
// 用于添加线程，core表示是否添加为核心线程
private boolean addWorker(Runnable firstTask, boolean core) {
    retry:
    for (;;) {
        int c = ctl.get();
        // 线程池运行状态
        int rs = runStateOf(c);

        // 如果线程池运行状态大于等于SHUTDOWN, 提交的firstTask为null, workQueue为null,返回false
        if (rs >= SHUTDOWN &&
            ! (rs == SHUTDOWN &&
               firstTask == null &&
               ! workQueue.isEmpty()))
            return false;

        for (;;) {
            // workerCount
            int wc = workerCountOf(c);
            // 线程数大于了2的29次方-1
            // 或者想要添加为核心线程但是核心线程池满
            // 或者想要添加为临时线程, 但是workerCount等于或大于了最大的线程池线程数maximumPoolSize, 返回false
            if (wc >= CAPACITY ||
                wc >= (core ? corePoolSize : maximumPoolSize))
                return false;
            // CAS的方式让workerCount数量增加1,如果成功, 终止循环
            if (compareAndIncrementWorkerCount(c))
                break retry;
            c = ctl.get();
            // 再次检查runState, 如果被更改, 重头执行retry代码
            if (runStateOf(c) != rs)
                continue retry;
            // 其他的, 上面的CAS如果由于workerCount被其他线程改变而失败, 继续内部的for循环
        }
    }

    // 标志位workerStarted, workerAdded
    boolean workerStarted = false;
    boolean workerAdded = false;
    Worker w = null;
    try {
        // 传入task对象, 创建Worker对象
        w = new Worker(firstTask);
        // 从worker对象中回去Thread对象
        final Thread t = w.thread;
        if (t != null) {
            final ReentrantLock mainLock = this.mainLock;
            // 获取mainLock锁
            mainLock.lock();
            try {
                // 获取mainLock锁之后, 再次检查runState
                int rs = runStateOf(ctl.get());

                // 如果是RUNNING状态, 或者是SHUTDOWN状态并且传入的task为null(执行workQueue中的task)
                if (rs < SHUTDOWN ||
                    (rs == SHUTDOWN && firstTask == null)) {
                    // 线程已经被启动, 抛出IllegalThreadStateException
                    if (t.isAlive()) 
                        throw new IllegalThreadStateException();
                    // 将worker对象添加到HashSet
                    workers.add(w);
                    int s = workers.size();
                    // 线程池中曾经达到的最大线程数(上面4.2.6提到过)
                    if (s > largestPoolSize)
                        largestPoolSize = s;
                    // worker被添加成功
                    workerAdded = true;
                }
            } finally {
                // 释放mainLock锁
                mainLock.unlock();
            }
            // 如果worker被添加成功, 启动线程, 执行对应的task
            if (workerAdded) {
                t.start();
                workerStarted = true;
            }
        }
    } finally {
        // 如果线程启动失败, 执行addWorkerFailed方法，将以修改的操作回滚
        if (! workerStarted)
            addWorkerFailed(w);
    }
    return workerStarted;
}

```



8. submit和excute
   * submit可以提交Runnable任务和Callable任务；excute只能提交Runnable任务。
   * **使用`execute()`提交任务**：当任务通过`execute()`提交到线程池并在执行过程中抛出异常时，如果这个异常没有在任务内被捕获，那么该异常会导致当前线程终止，并且异常会被打印到控制台或日志文件中。线程池会检测到这种线程终止，并创建一个新线程来替换它，从·而保持配置的线程数不变。
   * **使用`submit()`提交任务**：对于通过`submit()`提交的任务，如果在任务执行中发生异常，这个异常不会直接打印出来。相反，异常会被封装在由`submit()`返回的`Future`对象中。当调用`Future.get()`方法时，可以捕获到一个`ExecutionException`。在这种情况下，线程不会因为异常而终止，它会继续存在于线程池中，准备执行后续的任务。





