# Synchronize Block / Method Example: 
 
 * Each object in Java is associated with a monitor / Intrinsic Locks.
 * Which a thread can lock or unlock. Only one thread at a time may hold a lock on a monitor.
 * Synchronization is built around an internal entity known as the intrinsic lock or monitor lock.
 
## Reentrant Synchronization
    Recall that a thread cannot acquire a lock owned by another thread. But a thread can acquire a lock that it 
    already owns. Allowing a thread to acquire the same lock more than once enables reentrant synchronization.
     This describes a situation where synchronized code, directly or indirectly, invokes a method that also contains 
     synchronized code, and both sets of code use the same lock. Without reentrant synchronization, synchronized code 
     would have to take many additional precautions to avoid having a thread cause itself to block.
 
 ## Volatile and Synchronized
 
 
 ## More 
https://docs.oracle.com/javase/tutorial/essential/concurrency/locksync.html
