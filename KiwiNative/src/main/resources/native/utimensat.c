#include <sys/syscall.h>
#include "utimensat.h"
int utimensat(int dirfd, const char *pathname,
        const struct timespec times[2], int flags) {
    return syscall(__NR_utimensat, dirfd, pathname, times, flags);
}
int futimens(int fd, const struct timespec times[2]) {
    return utimensat(fd, NULL, times, 0);
}

void* lfind(const void *key, const void * base, size_t num, size_t width, int (*fncomparision)(const void *, const void *))
{
    char* Ptr = (char*)base;
    size_t ind = 0;
    for (ind = 0; ind != num; ind++, Ptr+=width)
    {
        if (fncomparision(key, Ptr) == 0) return Ptr;
    }
    return NULL;
}