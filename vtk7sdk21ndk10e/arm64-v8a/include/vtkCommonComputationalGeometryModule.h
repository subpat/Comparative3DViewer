
#ifndef VTKCOMMONCOMPUTATIONALGEOMETRY_EXPORT_H
#define VTKCOMMONCOMPUTATIONALGEOMETRY_EXPORT_H

#ifdef VTKCOMMONCOMPUTATIONALGEOMETRY_STATIC_DEFINE
#  define VTKCOMMONCOMPUTATIONALGEOMETRY_EXPORT
#  define VTKCOMMONCOMPUTATIONALGEOMETRY_NO_EXPORT
#else
#  ifndef VTKCOMMONCOMPUTATIONALGEOMETRY_EXPORT
#    ifdef vtkCommonComputationalGeometry_EXPORTS
        /* We are building this library */
#      define VTKCOMMONCOMPUTATIONALGEOMETRY_EXPORT 
#    else
        /* We are using this library */
#      define VTKCOMMONCOMPUTATIONALGEOMETRY_EXPORT 
#    endif
#  endif

#  ifndef VTKCOMMONCOMPUTATIONALGEOMETRY_NO_EXPORT
#    define VTKCOMMONCOMPUTATIONALGEOMETRY_NO_EXPORT 
#  endif
#endif

#ifndef VTKCOMMONCOMPUTATIONALGEOMETRY_DEPRECATED
#  define VTKCOMMONCOMPUTATIONALGEOMETRY_DEPRECATED 
#  define VTKCOMMONCOMPUTATIONALGEOMETRY_DEPRECATED_EXPORT VTKCOMMONCOMPUTATIONALGEOMETRY_EXPORT 
#  define VTKCOMMONCOMPUTATIONALGEOMETRY_DEPRECATED_NO_EXPORT VTKCOMMONCOMPUTATIONALGEOMETRY_NO_EXPORT 
#endif

#define DEFINE_NO_DEPRECATED 0
#if DEFINE_NO_DEPRECATED
# define VTKCOMMONCOMPUTATIONALGEOMETRY_NO_DEPRECATED
#endif



#endif
