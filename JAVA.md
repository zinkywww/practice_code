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

### 5. String

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

### 6. 包装类

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

### 7. static关键字

* 静态变量：静态变量也就是被 `static` 关键字修饰的变量。它可以被类的所有实例共享，无论一个类创建了多少个对象，它们都共享同一份静态变量。也就是说，静态变量只会被分配一次内存，即使创建多个对象，这样可以节省内存。
* 静态方法：静态方法是属于类的，而不是属于某个实例的。可以通过类名直接调用静态方法。静态方法不能访问实例变量和实例方法，因为它们没有特定的实例上下文。静态方法常用于工具类或辅助方法（如 `Math` 类中的方法）。
* 静态代码块：在类加载时加载，静态代码块用于初始化静态变量，且在类加载时执行一次

### 8. 成员变量和局部变量

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

### 9. 错误与异常

1. error与exception区别？
   * error和exception都继承自throwable类。
   * error表示java运行时系统的内部错误和资源耗尽问题，不应该抛出这样的错误，出现了这样的错误，应该通知用户，并尽可能的妥善的终止程序，程序无法处理这样的错误，如 Java 虚拟机运行错误（`Virtual MachineError`）、内存溢出(`OutOfMemoryError`)。
   * exception表示一种设计和实现问题。exception有两个分支：exception直接子类（受检异常），RuntimeException（运行时异常）。
     * 受检异常：Java 代码在编译过程中，如果受检查异常没有被 `catch`或者`throws` 关键字处理的话，就没办法通过编译。常见有IO相关异常。
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

### 10. 反射

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
     * 通过 `Proxy.newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h)` 方法创建代理对象；其中loader和interface通过**反射**获取。

### 11. 集合![Java 集合框架概览](https://oss.javaguide.cn/github/javaguide/java/collection/java-collection-hierarchy.png)

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

4. HashTable和HashSet

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


### 11. volatile关键字

* 保证变量的可见性，如果我们将变量声明为 **`volatile`** ，这就指示 JVM，这个变量是共享且不稳定的，每次使用它都到主存中进行读取。
* **防止 JVM 的指令重排序。** 如果我们将变量声明为 **`volatile`** ，在对这个变量进行读写操作的时候，会通过插入特定的 **内存屏障** 的方式来禁止指令重排序。
* 不保证原子性。

### 12. synchronized关键字

1. 用法
   * 修饰实例方法：调用方法要获取内部对象锁。
   * 修饰静态方法：获取.class对象锁。
   * 修饰代码块：获取给定对象的锁。
2. 原理
   * `synchronized` 同步语句块的实现使用的是 `monitorenter` 和 `monitorexit` 指令，其中 `monitorenter` 指令指向同步代码块的开始位置，`monitorexit` 指令则指明同步代码块的结束位置。在执行`monitorenter`时，会尝试获取对象的锁，如果锁的计数器为 0 则表示锁可以被获取，获取后将锁计数器设为 1 也就是加 1。对象锁的的拥有者线程才可以执行 `monitorexit` 指令来释放锁。在执行 `monitorexit` 指令后，将锁计数器设为 0，表明锁被释放，其他线程可以尝试获取锁。
   * `synchronized` 修饰的方法并没有 `monitorenter` 指令和 `monitorexit` 指令，取得代之的确实是 `ACC_SYNCHRONIZED` 标识，该标识指明了该方法是一个同步方法。
   * **不过两者的本质都是对对象监视器 monitor 的获取。**

### 12. JUC同步

1. ReentrantLock

   * `ReentrantLock` 实现了 `Lock` 接口，是一个可重入且独占式的锁，和 `synchronized` 关键字类似。不过，`ReentrantLock` 更灵活、更强大，增加了轮询、超时、中断、公平锁和非公平锁等高级功能。`ReentrantLock` 里面有一个内部类 `Sync`，`Sync` 继承 AQS（`AbstractQueuedSynchronizer`），添加锁和释放锁的大部分操作实际上都是在 `Sync` 中实现的。`Sync` 有公平锁 `FairSync` 和非公平锁 `NonfairSync` 两个子类。

   * 与synchronized：

     * 都是可重入锁。

     * `synchronized` 是依赖于 JVM 实现的，前面我们也讲到了 虚拟机团队在 JDK1.6 为 `synchronized` 关键字进行了很多优化，但是这些优化都是在虚拟机层面实现的，并没有直接暴露给我们。

       `ReentrantLock` 是 JDK 层面实现的（也就是 API 层面，需要 lock() 和 unlock() 方法配合 try/finally 语句块来完成），所以我们可以通过查看它的源代码，来看它是如何实现的。

     * **等待可中断** : `ReentrantLock`提供了一种能够中断等待锁的线程的机制，通过 `lock.lockInterruptibly()` 来实现这个机制。也就是说正在等待的线程可以选择放弃等待，改为处理其他事情。

       **可实现公平锁** : `ReentrantLock`可以指定是公平锁还是非公平锁。而`synchronized`只能是非公平锁。所谓的公平锁就是先等待的线程先获得锁。`ReentrantLock`默认情况是非公平的，可以通过 `ReentrantLock`类的`ReentrantLock(boolean fair)`构造方法来指定是否是公平的。

       **可实现选择性通知（锁可以绑定多个条件）**: `synchronized`关键字与`wait()`和`notify()`/`notifyAll()`方法相结合可以实现等待/通知机制。`ReentrantLock`类当然也可以实现，但是需要借助于`Condition`接口与`newCondition()`方法。

2. ReentrantReadWriteLock

   * `ReentrantReadWriteLock` 其实是两把锁，一把是 `WriteLock` (写锁)，一把是 `ReadLock`（读锁） 。读锁是共享锁，写锁是独占锁。读锁可以被同时读，可以同时被多个线程持有，而写锁最多只能同时被一个线程持有。

3. Atomic原子类

   * 利用volatile和CAS而没有使用锁，提供了一些原子方法操作数值。
   * 基本类型
   * 数组类型：使用原子的方式更新数组里的某个元素
   * 引用类型：把对象设置进原子类引用对象中，使用CAS设置。

### 13. JUC并发容器