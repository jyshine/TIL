
class Cache {
}
class DiskCache extends Cache { }
class MemoryCatch extends Cache { }
class OptimizedDiskCache extends DiskCache { }

public class Test2 {
    public static void main(String[] args) {
        Cache cache = new Cache();
        DiskCache diskCache = new DiskCache();
        MemoryCatch memoryCatch = new MemoryCatch();
        OptimizedDiskCache optimizedDiskCache = new OptimizedDiskCache();

//        Cache cache1 = (Cache)optimizedDiskCache;
//        Cache cache2 = (Cache) memoryCatch;
//        DiskCache diskCache1 = (DiskCache) cache2;

//        OptimizedDiskCache optimizedDiskCache1 = (OptimizedDiskCache) diskCache;

//        DiskCache diskCache1 = (DiskCache) optimizedDiskCache;

//        MemoryCatch memoryCatch1 = (MemoryCatch) cache;

        OptimizedDiskCache optimizedDiskCache1 = new OptimizedDiskCache();
        Cache cache1 = (Cache) optimizedDiskCache1;
        DiskCache diskCache1 = (DiskCache) cache1;
    }
}
