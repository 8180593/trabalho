package ClassImplementation;

//https://developer.classpath.org/doc/java/util/HashMap-source.html

/*import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class HashMap<K, V> extends AbstractMap<K, V> implements Map<K, V>, Cloneable, Serializable {
          static final int DEFAULT_CAPACITY = 11;

       static final float DEFAULT_LOAD_FACTOR = 0.75f;

       private static final long serialVersionUID = 362498820763181265L;

       private int threshold;

       final float loadFactor;

       transient HashEntry<K, V>[] buckets;
       transient int modCount;

       transient int size;

       private transient Set<Map.Entry<K, V>> entries;

       static class HashEntry<K, V> extends AbstractMap.SimpleEntry<K, V> {

            HashEntry<K, V> next;

         HashEntry(K key, V value) {
             super(key, value);
        }
        void access() {
         }
         V cleanup() {
             return value;
        }
       }

        public HashMap(){
           this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
        }

        public HashMap(Map<? extends K, ? extends V> m) {
             this(Math.max(m.size() * 2, DEFAULT_CAPACITY), DEFAULT_LOAD_FACTOR);
             putAll(m);
        }

           public HashMap(int initialCapacity)
           {
             this(initialCapacity, DEFAULT_LOAD_FACTOR);
           }

           public HashMap(int initialCapacity, float loadFactor)
           {
             if (initialCapacity < 0)
               throw new IllegalArgumentException("Illegal Capacity: "
                                                  + initialCapacity);
             if (! (loadFactor > 0)) // check for NaN too
               throw new IllegalArgumentException("Illegal Load: " + loadFactor);

             if (initialCapacity == 0)
               initialCapacity = 1;
             buckets = (HashEntry<K, V>[]) new HashEntry[initialCapacity];
             this.loadFactor = loadFactor;
             threshold = (int) (initialCapacity * loadFactor);
        }

           public int size()
           {
             return size;
           }

           public boolean isEmpty()
           {
             return size == 0;
           }
           public V get(Object key)
           {
             int idx = hash(key);
             HashEntry<K, V> e = buckets[idx];
             while (e != null)
               {
                 if (equals(key, e.key))
                   return e.value;
                 e = e.next;
               }
             return null;
           }
           public boolean containsKey(Object key)
           {
             int idx = hash(key);
             HashEntry<K, V> e = buckets[idx];
             while (e != null)
               {
                 if (equals(key, e.key))
                 return true;
                 e = e.next;
              }
             return false;
           }

           public V put(K key, V value){
             int idx = hash(key);
             HashEntry<K, V> e = buckets[idx];
             while (e != null)
               {
               if (equals(key, e.key))
                   {
                     e.access();
               V r = e.value;
                    e.value = value;
                     return r;
                   }
                 else
                  e = e.next;
               }

             modCount++;
             if (++size > threshold)
               {
                 rehash();
                 idx = hash(key);
               }

             addEntry(key, value, idx, true);
             return null;
           }

           public void putAll(Map<? extends K, ? extends V> m)
           {
             final Map<K,V> addMap = m;
             final Iterator<Map.Entry<K,V>> it = addMap.entrySet().iterator();
             while (it.hasNext())
               {
             final Map.Entry<K,V> e = it.next();
                 // Optimize in case the Entry is one of our own.
                 if (e instanceof AbstractMap.SimpleEntry<? extends K, ? extends V> entry)
                   {
                       put(entry.key, entry.value);
                   }
                 else
                   put(e.getKey(), e.getValue());
               }
           }
   public V remove(Object key)
           {
             int idx = hash(key);
            HashEntry<K, V> e = buckets[idx];
             HashEntry<K, V> last = null;

             while (e != null)
              {
                 if (equals(key, e.key))
                  {
                     modCount++;
                     if (last == null)
                       buckets[idx] = e.next;
                     else
                       last.next = e.next;
                     size--;
                     // Method call necessary for LinkedHashMap to work correctly.
                    return e.cleanup();
                   }
                 last = e;
                 e = e.next;
               }
             return null;
           }

           public void clear()
           {
             if (size != 0)
               {
                modCount++;
                 Arrays.fill(buckets, null);
                 size = 0;
               }
           }

           public boolean containsValue(Object value)
           {
            for (int i = buckets.length - 1; i >= 0; i--)
               {
                 HashEntry<K, V> e = buckets[i];
                 while (e != null)
                   {
                     if (equals(value, e.value))
                       return true;
                     e = e.next;
                   }
               }
             return false;
           }

           public Object clone()
           {
             HashMap<K, V> copy = null;
             try
               {
                 copy = (HashMap<K, V>) super.clone();
               }
             catch (CloneNotSupportedException x)
               {
                 // This is impossible.
               }
             copy.buckets = (HashEntry<K, V>[]) new HashEntry[buckets.length];
            copy.putAllInternal(this);
             // Clear the entry cache. AbstractMap.clone() does the others.
             copy.entries = null;
             return copy;
           }

           public Set<K> keySet()
           {
            if (keys == null)
               // Create an AbstractSet with custom implementations of those methods
               // that can be overridden easily and efficiently.
               keys = new AbstractSet<K>()
               {
                public int size()
                 {
                   return size;
                 }

                 public Iterator<K> iterator()
                 {
                  // Cannot create the iterator directly, because of LinkedHashMap.
                   return HashMap.this.iterator(KEYS);
                 }

                 public void clear()
                 {
                  HashMap.this.clear();
                 }

                 public boolean contains(Object o)
                 {
                   return containsKey(o);
                 }

                 public boolean remove(Object o)
                 {
                   int oldsize = size;
                   HashMap.this.remove(o);
                   return oldsize != size;
                 }
               };
             return keys;
           }
           public Collection<V> values()
           {
             if (values == null)
               // We don't bother overriding many of the optional methods, as doing so
               // wouldn't provide any significant performance advantage.
              values = new AbstractCollection<V>()
               {
                 public int size()
                 {
                   return size;
                 }

                 public Iterator<V> iterator()
                 {
                  // Cannot create the iterator directly, because of LinkedHashMap.
                  return HashMap.this.iterator(VALUES);
                 }

                 public void clear()
                 {
                   HashMap.this.clear();
                 }
               };
             return values;
           }
         public Set<Map.Entry<K, V>> entrySet()
           {
             if (entries == null)
               // Create an AbstractSet with custom implementations of those methods
               // that can be overridden easily and efficiently.
               entries = new AbstractSet<Map.Entry<K, V>>()
               {
                 public int size()
                 {
                   return size;
                 }

                 public Iterator<Map.Entry<K, V>> iterator()
                 {
                   // Cannot create the iterator directly, because of LinkedHashMap.
                   return HashMap.this.iterator(ENTRIES);
                 }

                 public void clear()
                 {
                   HashMap.this.clear();
                 }

                 public boolean contains(Object o)
                 {
                   return getEntry(o) != null;
                 }

                 public boolean remove(Object o)
                 {
                   HashEntry<K, V> e = getEntry(o);
                   if (e != null)
                     {
                       HashMap.this.remove(e.key);
                       return true;
                     }
                   return false;
                 }
               };
             return entries;
           }

           void addEntry(K key, V value, int idx, boolean callRemove)
           {
             HashEntry<K, V> e = new HashEntry<K, V>(key, value);
             e.next = buckets[idx];
             buckets[idx] = e;
           }
          final HashEntry<K, V> getEntry(Object o)
           {
             if (! (o instanceof Map.Entry<K, V> me))
               return null;
               K key = me.getKey();
             int idx = hash(key);
             HashEntry<K, V> e = buckets[idx];
             while (e != null)
               {
                 if (equals(e.key, key))
                   return equals(e.value, me.getValue()) ? e : null;
                 e = e.next;
               }
             return null;
           }

           final int hash(Object key)
           {
             return key == null ? 0 : Math.abs(key.hashCode() % buckets.length);
           }

           <T> Iterator<T> iterator(int type)
           {
             // FIXME: bogus cast here.
            return new HashIterator<T>(type);
           }
           void putAllInternal(Map<? extends K, ? extends V> m)
           {
             final Map<K,V> addMap = m;
            final Iterator<Map.Entry<K,V>> it = addMap.entrySet().iterator();
             size = 0;
            while (it.hasNext())
               {
             final Map.Entry<K,V> e = it.next();
                 size++;
             K key = e.getKey();
             int idx = hash(key);
            addEntry(key, e.getValue(), idx, false);
              }
          }
           private void rehash()
           {
             HashEntry<K, V>[] oldBuckets = buckets;

             int newcapacity = (buckets.length * 2) + 1;
             threshold = (int) (newcapacity * loadFactor);
             buckets = (HashEntry<K, V>[]) new HashEntry[newcapacity];

             for (int i = oldBuckets.length - 1; i >= 0; i--)
               {
                 HashEntry<K, V> e = oldBuckets[i];
                 while (e != null)
                   {
                     int idx = hash(e.key);
                     HashEntry<K, V> dest = buckets[idx];
                     HashEntry<K, V> next = e.next;
                     e.next = buckets[idx];
                     buckets[idx] = e;
                     e = next;
                   }
               }
           }
           private void writeObject(ObjectOutputStream s) throws IOException
           {
             // Write the threshold and loadFactor fields.
             s.defaultWriteObject();

             s.writeInt(buckets.length);
             s.writeInt(size);
             // Avoid creating a wasted Set by creating the iterator directly.
             Iterator<HashEntry<K, V>> it = iterator(ENTRIES);
             while (it.hasNext())
               {
                 HashEntry<K, V> entry = it.next();
                 s.writeObject(entry.key);
                 s.writeObject(entry.value);
               }
           }
           private void readObject(ObjectInputStream s)
             throws IOException, ClassNotFoundException
          {
            s.defaultReadObject();

             buckets = (HashEntry<K, V>[]) new HashEntry[s.readInt()];
             int len = s.readInt();
            size = len;
             while (len-- > 0)
               {
                 Object key = s.readObject();
                addEntry((K) key, (V) s.readObject(), hash(key), false);
               }
           }
           private final class HashIterator<T> implements Iterator<T> {
             private final int type;
             private int knownMod = modCount;

             private int count = size;
             private int idx = buckets.length;
             private HashEntry last;
         private HashEntry next;
             HashIterator(int type)
             {
               this.type = type;
             }

             public boolean hasNext()
             {
               return count > 0;
             }
             public T next()
            {
               if (knownMod != modCount)
                 throw new ConcurrentModificationException();
               if (count == 0)
                 throw new NoSuchElementException();
              count--;
               HashEntry e = next;

               while (e == null)
                 e = buckets[--idx];

               next = e.next;
               last = e;
                if (type == VALUES)
                 return (T) e.value;
              if (type == KEYS)
                return (T) e.key;
              return (T) e;
            }
            public void remove()
            {
              if (knownMod != modCount)
                throw new ConcurrentModificationException();
              if (last == null)
                throw new IllegalStateException();

              HashMap.this.remove(last.key);
              last = null;
              knownMod++;
           }
       }
}*/
